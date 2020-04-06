package com.company.main;

import com.alibaba.fastjson.JSON;
import com.company.account.Account;
import com.company.authorization.Authorization;

import java.io.FileWriter;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.company.cardmanager.CardManager;
import com.company.cardset.CardSet;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            String log4jConfPath = "D:\\OneDrive\\Study\\Course_2\\2\\Java\\" +
                                    "Solutions\\Lab3&4\\src\\resources\\log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);
            log.info("Start program...!");

            // Lab05 start here
            CardSet cardSet = new CardSet();
            CardManager cm = new CardManager();
            cm.createCardSet(cardSet);

            Account newAcc = new Account();

            try(FileWriter writer = new FileWriter("card.json", false))
            {
                String jsonString =  JSON.toJSONString(newAcc);
                writer.write(jsonString);
            }

            System.out.println("Count of accounts -> " + cardSet.cardSet.stream().count());
            System.out.println("Sum of accounts -> " + cardSet.cardSet.stream().mapToDouble((s) -> s.getBalanceAmount()).sum());
            System.out.println("Average of accounts balance -> " + cardSet.cardSet.stream().mapToDouble(s -> s.getBalanceAmount()).average());


            
            // End

            for (Account item: cardSet.getCardSet()) {
                System.out.println(item.toString());
            }

            CardSet secCardSet = new CardSet();
            cm.generateCardSet(secCardSet);
            for (Account item: secCardSet.getCardSet()) {
                System.out.println(item.toString());
            }

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
