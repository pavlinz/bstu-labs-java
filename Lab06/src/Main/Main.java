package Main;

import Port.Port;
import Ships.UnloadingShip;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of piers -> ");
        int numberOfPiers = in.nextInt();
        System.out.print("Enter the number of unloading ships -> ");
        int numberOfUnloadingShips = in.nextInt();
        System.out.print("Enter the number of loading ship -> ");
        int numberOfLoadingShips = in.nextInt();

        Port mainPort = new Port();
        System.out.println("Port created");
        mainPort.addItems(numberOfPiers);

        for (int i = 0; i < numberOfUnloadingShips; i++){
            System.out.println("New unloading ship come");
            new Thread(new UnloadingShip(mainPort, "Ship " + i)).start();
        }
        Thread.sleep(3000);
    }
}
