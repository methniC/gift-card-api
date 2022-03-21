package com.guusto.giftcardservice.repository;

import com.guusto.giftcardservice.entity.Balance;
import com.guusto.giftcardservice.entity.GiftCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance , Long>
{

}
