package com.company.entities;

import com.company.card.DebitCard;
import com.company.card.OverdraftCard;
import java.util.Scanner;

public class Client implements IClient {
    public DebitCard dc;
    public boolean dcFlag;
    public OverdraftCard oc;
    public boolean ocFlag;

    public Client(byte typeOfCard) {
        if (typeOfCard == 1) {
            dc = new DebitCard();
            dcFlag = true;
        }
        else if (typeOfCard == 2) {
            oc = new OverdraftCard();
            ocFlag = true;
        }
    }

    @Override
    public void showBalance() {
        if (dcFlag == true && dc.account.isStatus() == true) {
            System.out.println(dc.getBalance());
        }
        else if (ocFlag && oc.account.isStatus() == true) {
            System.out.println(oc.getBalance());
        }
    }

    @Override
    public boolean blockCard() {

        if (dcFlag == true && dc.account.isStatus() == true) {
            System.out.println("\nYour card was blocked\n");
            dc.account.setStatus(false);
            return true;
        }
        else if (ocFlag == true && oc.account.isStatus() == true) {
            System.out.print("\nYour card was blocked\n");
            oc.account.setStatus(false);
            return true;
        }
        else {
            System.out.println("Card is already locked");
            return false;
        }
    }

    @Override
    public boolean makePayment() {
        if (dcFlag == true && dc.account.isStatus() == true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter cost: ");
            dc.makePurchase(in.nextDouble());
            System.out.println();
            return true;
        }
        else if (ocFlag == true && oc.account.isStatus() == true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter cost: ");
            oc.makePurchase(in.nextDouble());
            System.out.println();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean replenishAccount() {
        Scanner in = new Scanner(System.in);

        if (dcFlag == true && dc.account.isStatus() == true) {
            System.out.print("\nPlease, enter the amount which you replenish: ");
            dc.refill(in.nextDouble());
            System.out.println();
            return true;
        }
        else if (ocFlag == true && oc.account.isStatus() == true) {
            System.out.print("\nPlease, enter the amount which you replenish: ");
            oc.refill(in.nextDouble());
            System.out.println();
            return true;
        }
        else {
            return false;
        }
    }
}
