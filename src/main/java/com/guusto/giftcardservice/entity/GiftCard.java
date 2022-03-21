package com.guusto.giftcardservice.entity;

import javax.persistence.*;

@Entity
@Table
public class GiftCard {

    @Id
   @SequenceGenerator(
            name = "gift_card_sequence" ,
            sequenceName = "gift_card_sequence" ,
            allocationSize = 1
    )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator = "gift_card_sequence"
            )
    @Column(name= "transaction_id")
    private long transactionId;
    private long clientId;
    private double balance;
    private int numOfGiftCards;
    private int quantity;
    private double amount;

    public GiftCard() {
    }

    public GiftCard(int quantity, double amount) {
        this.quantity = quantity;
        this.amount = amount;
    }

    public GiftCard(long clientId, long transactionId, double balance, int numOfGiftCards, int quantity, double amount) {

        this.transactionId = transactionId;
        this.clientId = clientId;
        this.balance = balance;
        this.numOfGiftCards = numOfGiftCards;
        this.quantity = quantity;
        this.amount = amount;
    }

    public GiftCard(long clientId, double balance, int numOfGiftCards, int quantity, double amount) {
        this.clientId = clientId;
        this.balance = balance;
        this.numOfGiftCards = numOfGiftCards;
        this.quantity = quantity;
        this.amount = amount;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumOfGiftCards() {
        return numOfGiftCards;
    }

    public void setNumOfGiftCards(int numOfGiftCards) {
        this.numOfGiftCards = numOfGiftCards;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
