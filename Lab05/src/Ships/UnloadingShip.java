package Ships;

import Pier.Pier;
import Port.Port;

public class UnloadingShip implements Runnable {

    Port port;
    private int shipCapacity = 50;
    public String shipName;

    public UnloadingShip(Port port, String shipName) {
        this.port = port;
        this.shipName = shipName;
    }

    @Override
    public void run() {
        for (Pier item:port.piers) {
                if (item.inLoad == false) {
                    synchronized (item) {
                        System.out.println(shipName + " begins unloading on the " + item.nameOfPier);
                        item.inLoad = true;
                        try {
                            while (shipCapacity != 0) {
                                System.out.println("Current port capacity " + port.getCurrentCapacity());
                                port.currentCapacity += 5;
                                shipCapacity -= 5;
                                Thread.sleep(5000);
                            }
                            System.out.println(shipName + " unloaded");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else{
                    continue;
                }
        }
    }
}
