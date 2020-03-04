package com.company.card;

import java.util.Scanner;

public class OverdraftCard extends Card {

    @Override
    public void makePurchase(double cost) {

        if((account.getBalanceAmount() - cost) < 0 || account.getBalanceAmount() == 0) {
            Scanner in = new Scanner(System.in);
            byte answer = 0;
            System.out.print("\nMake a purchase at a percentage? (1 - yes, 2 - no) ");
            while(answer != 1 && answer != 2) {
                System.out.print("Input:");
                answer = in.nextByte();
                System.out.println();
            }

            if(answer == 1) {
                double sub = cost - account.getBalanceAmount();
                System.out.println("Not enough " + sub);
                System.out.println("\n" + "Loan at 30% in the amount of " + sub);
                account.setBalanceAmount(0);
            }
            else if (answer == 2) {
                System.out.println("Continue");
            }
        }
        else {
            account.purchase(cost);
            System.out.println("\nSuccessful transaction\n");
        }
    }

    @Override
    public void refill(double amount) {
        double commission = amount * 0.02;
        amount -= commission;
        account.replenishAccount(amount);
    }

}
