package com.company.main;

import com.company.authorization.Authorization;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);
            byte answer = 0;
            System.out.println("Authorization: \n 1-Client \n 2-Admin\n");

            while (answer != 1 && answer != 2) {
                System.out.print("Input:");
                answer = in.nextByte();
                System.out.println();
            }

            Authorization authorization = new Authorization(answer);

            if (authorization.clientFlag) {
                int choice = 1;
                while (choice != 0) {

                    System.out.println("1-Show balance");
                    System.out.println("2-Replenish account");
                    System.out.println("3-Block card");
                    System.out.println("4-Make payment");
                    System.out.println("0-Exit");

                    System.out.print("\nInput:");
                    choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            authorization.client.showBalance();
                            break;
                        case 2:
                            authorization.client.replenishAccount();
                            break;
                        case 3:
                            authorization.client.blockCard();
                            break;
                        case 4:
                            authorization.client.makePayment();
                            break;
                    }
                }
            } else if (authorization.adminFlag) {
                int choice = 0;
                while (choice != 0) {

                    System.out.println("1-Block card");
                    System.out.println("2-Unlock card");
                    System.out.println("0-Exit");

                    switch (choice) {
                        case 1:
                            authorization.admin.blockCard();
                            break;
                        case 2:
                            authorization.admin.unlockCard();
                            break;
                    }
                }
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
