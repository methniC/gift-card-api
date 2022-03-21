package com.guusto.giftcardservice.controller;

import com.guusto.giftcardservice.entity.GiftCard;
import com.guusto.giftcardservice.service.GiftCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guusto-service")
public class GiftCardController {

    public static final Logger log = LoggerFactory.getLogger(GiftCardController.class);

    @Autowired
    private GiftCardService giftCardService;

/*
    @Autowired
    public GiftCardController(GiftCardService giftCardService) {
        this.giftCardService = giftCardService;
    }*/

    @GetMapping(value = "get-message")
    public String getMessage()
    {
        return "Hello";
    }


    @GetMapping(value = "/buy-gift")
    public List<GiftCard> buyGift() {
        return giftCardService.saveUpdateGiftCardCount();
    }

    @PostMapping(value = "/buy-gift-cards")
    public ResponseEntity purchaseGiftCard(@RequestBody List<GiftCard> giftCards)
    {
        return giftCardService.savePurchasedCards(giftCards);

    }

}
