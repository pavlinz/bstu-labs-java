package com.company.card;

import com.company.account.Account;

public abstract class Card {



    public Account account;

    public Card() {
        account = new Account(0, true);
    }

    public String getBalance() {
        return "\nIn your account " + account.toString() + "\n";
    }

    public abstract void refill(double amount);                             // override for each card classes

    public abstract void makePurchase(double cost);
}
