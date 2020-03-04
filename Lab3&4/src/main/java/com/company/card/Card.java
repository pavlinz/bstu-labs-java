package com.company.card;

import com.company.account.Account;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public abstract class Card {
    private static final Logger log = Logger.getLogger(Card.class);
    String log4jConfPath = "D:\\OneDrive\\Study\\Course_2\\2\\Java\\" +
            "Solutions\\Lab3&4\\src\\resources\\log4j.properties";

    public Account account;

    public Card() {
        PropertyConfigurator.configure(log4jConfPath);
        account = new Account(0, true);
        log.info("New card created");
    }

    public String getBalance() {
        return "\nIn your account " + account.toString() + "\n";
    }

    public abstract void refill(double amount);                             // override for each card classes

    public abstract void makePurchase(double cost);
}
