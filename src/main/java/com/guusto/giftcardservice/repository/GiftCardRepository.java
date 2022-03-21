package com.guusto.giftcardservice.repository;

import com.guusto.giftcardservice.entity.GiftCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GiftCardRepository extends JpaRepository<GiftCard ,Long> {

    @Query(value = "SELECT s FROM gift_card s WHERE s.client_id = ?1" , nativeQuery = true)
    List<GiftCard> getFinalBalance(long clientId);


}
