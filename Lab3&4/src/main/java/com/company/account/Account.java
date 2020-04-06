package com.company.account;

import com.company.card.Card;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Account {

    private static final Logger log = Logger.getLogger(Card.class);
    String log4jConfPath = "D:\\OneDrive\\Study\\Course_2\\2\\Java\\" +
            "Solutions\\Lab3&4\\src\\resources\\log4j.properties";

    private double balanceAmount;
    private boolean status;

    public Account() {}

    public Account(double balanceAmount, boolean status) {
        PropertyConfigurator.configure(log4jConfPath);
        this.balanceAmount = balanceAmount;
        this.status = status;
        log.info("New account created");
    }

    public void replenishAccount(double amount) {
        balanceAmount += amount;
        log.info("Account replenished");
    }

    public void purchase(double cost) {

        balanceAmount -= cost;
    }

    @Override
    public String toString() {
        return String.valueOf(getBalanceAmount()) + " " + String.valueOf(isStatus());
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
