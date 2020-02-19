package com.company.authorization;

import com.company.entities.Admin;
import com.company.entities.Client;

import java.util.Scanner;

public class Authorization {
    public byte typeOfEntities;
    public Client client;
    public boolean clientFlag;
    public Admin admin;
    public boolean adminFlag;

    public Authorization(byte typeOfEntities) {

        this.typeOfEntities = typeOfEntities;
        if (typeOfEntities == 1) {
            Scanner in = new Scanner(System.in);
            byte answer = 0;

            System.out.println("Type of card: \n 1-DebitCard \n 2-OverdraftCard\n");

            while(answer != 1 && answer != 2) {
                System.out.print("Input:");
                answer = in.nextByte();
                System.out.print("\n");
            }

            client = new Client(answer);
            clientFlag = true;
        }
        else if (typeOfEntities == 2) {
            admin = new Admin();
            adminFlag = true;
        }
    }
}
