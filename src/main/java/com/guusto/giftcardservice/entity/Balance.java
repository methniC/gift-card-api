package com.guusto.giftcardservice.entity;

import javax.persistence.*;

@Entity
@Table
public class Balance {


        @Id
        private long clientId;
        private double balance;

        public Balance() {
        }

        public Balance(long clientId, double balance) {
                this.clientId = clientId;
                this.balance = balance;
        }

        public long getClientId() {
                return clientId;
        }

        public void setClientId(long clientId) {
                this.clientId = clientId;
        }

        public double getBalance() {
                return balance;
        }

        public void setBalance(double balance) {
                this.balance = balance;
        }
}
