package com.guusto.giftcardservice.entity;

import com.guusto.giftcardservice.repository.BalanceRepository;
import com.guusto.giftcardservice.repository.GiftCardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GiftCardConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(GiftCardRepository giftCardRepository) {
        return args -> {
            GiftCard giftCard1 = new GiftCard(1000, 200.5, 2, 10, 45);
            GiftCard giftCard2 = new GiftCard(2000, 500, 20, 10, 2);

            Balance balance1 = new Balance(1000, 500);
            Balance balance2 = new Balance(2000, 200);

            giftCardRepository.saveAll(List.of(giftCard1, giftCard2));

        };

    }
    @Bean
    CommandLineRunner commandLineRunner1(BalanceRepository balanceRepository) {
        return args -> {

            Balance balance1 = new Balance(1000, 500);
            Balance balance2 = new Balance(1, 5000);

            balanceRepository.saveAll(List.of(balance1, balance2));

        };

    }
}
