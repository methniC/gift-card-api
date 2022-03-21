package com.guusto.giftcardservice.controller;

import com.guusto.giftcardservice.entity.Balance;
import com.guusto.giftcardservice.service.BalanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/guusto-service")
public class BalanceController {

    public BalanceService balanceService;

    /*@GetMapping(value = "get-balance")
    public List<Balance> getBalance()
    {
        return balanceService.getBalanceByTrsId();
    }*/
}
