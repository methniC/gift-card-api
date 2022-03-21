package com.guusto.giftcardservice.service;


import com.guusto.giftcardservice.controller.GiftCardController;
import com.guusto.giftcardservice.entity.Balance;
import com.guusto.giftcardservice.entity.GiftCard;
import com.guusto.giftcardservice.repository.BalanceRepository;
import com.guusto.giftcardservice.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiftCardService {

    @Autowired
    private  GiftCardRepository giftCardRepository;
    @Autowired
    private  BalanceRepository balanceRepository;


    public List<GiftCard> saveUpdateGiftCardCount() {
        return giftCardRepository.findAll();

    }

    public ResponseEntity savePurchasedCards(List<GiftCard> giftCards) {

        ResponseEntity responseEntity;
        long cliId = giftCards.get(0).getClientId();

        Balance balance = balanceRepository.getById(cliId);
        double initialBalance = balance.getBalance() ;
        double totalPriceForTransaction = 0.0D;

        //Need to consider the total price for the particular transaction because balance is not enough for the complete trs ,then we need to return
        for (GiftCard giftCard : giftCards)
        {
            totalPriceForTransaction += giftCard.getAmount() * giftCard.getQuantity();

        }
        GiftCardController.log.debug( "total price for all trs : " + totalPriceForTransaction);

        // TODO: 3/21/2022 get the records for the relevant client id only
        List<GiftCard> giftCardList = giftCardRepository.findAll();

        List<GiftCard> filteredList = giftCardList.stream()
                .filter(gift -> gift.getClientId() == (cliId)).collect(Collectors.toList());

        if (filteredList.isEmpty()) {//When no previous records are there for the relevant client

            responseEntity = processBalanceAmount(initialBalance , giftCards ,totalPriceForTransaction , balance);


        } else {
            double latestBalance = filteredList.get(filteredList.size() - 1).getBalance();
            responseEntity = processBalanceAmount(latestBalance , giftCards ,totalPriceForTransaction ,balance );

        }
        return responseEntity;
    }

    private ResponseEntity processBalanceAmount(double latestBalance , List<GiftCard> giftCards , double totalPriceForTransaction ,Balance balanceEntity )
    {
        double perTrsPrice = 0.0D;
        if (latestBalance >= totalPriceForTransaction) {
            for (GiftCard giftCard : giftCards) {

                perTrsPrice = giftCard.getAmount() * giftCard.getQuantity();
                latestBalance -= perTrsPrice;
                giftCard.setBalance(latestBalance);

            }
            if (latestBalance >= 0) {
                balanceEntity.setBalance(latestBalance);
                GiftCardController.log.debug( "Final Balance : " + latestBalance );
                giftCardRepository.saveAll(giftCards);
                balanceRepository.save(balanceEntity);
            }
        } else {
            GiftCardController.log.debug( "latestBalance " + latestBalance );
            return new ResponseEntity<>("Balance is not enough..", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully Processed..", HttpStatus.OK);
    }

}
