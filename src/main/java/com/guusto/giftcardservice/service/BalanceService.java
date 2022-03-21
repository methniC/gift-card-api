package com.guusto.giftcardservice.service;

import com.guusto.giftcardservice.entity.Balance;
import com.guusto.giftcardservice.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

public class BalanceService {

    public final BalanceRepository balanceRepository;

    @Autowired
    public BalanceService(BalanceRepository balanceRepository)
    {
        this.balanceRepository = balanceRepository;
    }


    public List<Balance> getBalance()
    {
        return balanceRepository.findAll();
    }
    public List<Balance> getBalanceByTrsId(long trsId)
    {
        return Collections.singletonList(balanceRepository.getById(trsId));
    }
}
