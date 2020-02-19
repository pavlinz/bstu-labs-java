package com.company.account;

public class Account {
    private double balanceAmount;
    private boolean status;



    public Account(double balanceAmount, boolean status) {
        this.balanceAmount = balanceAmount;
        this.status = status;
    }



    public void replenishAccount(double amount) {
        balanceAmount += amount;
    }

    public void purchase(double cost) {

        balanceAmount -= cost;
    }


    @Override
    public String toString() {
        return String.valueOf(getBalanceAmount());
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
