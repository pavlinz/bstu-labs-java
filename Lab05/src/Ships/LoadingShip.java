package Ships;

import Port.Port;

public class LoadingShip implements Runnable {

    final int shipCapacity = 50;
    Port port;

    public LoadingShip(Port port) {
        this.port = port;
    }

    @Override
    public void run() {

    }
}
