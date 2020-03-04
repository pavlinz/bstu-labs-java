package com.company.card;

public class DebitCard extends Card {

    @Override
    public void refill(double amount) {
        double commission = amount * 0.01;
        amount -= commission;
        account.replenishAccount(amount);
    }

    @Override
    public void makePurchase(double cost) {

        if((account.getBalanceAmount() - cost) < 0 || account.getBalanceAmount() == 0) {
            System.out.println("\nInsufficient funds to replenish the account\n");
        }
        else {
            account.purchase(cost);
            System.out.println("\nSuccessful transaction\n");
        }
    }
}
