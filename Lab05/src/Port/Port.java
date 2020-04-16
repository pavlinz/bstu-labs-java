package Port;

import Pier.Pier;
import java.util.LinkedList;


public class Port {

    public LinkedList<Pier> piers = new LinkedList<Pier>();
    private final int capacity = 1000;
    public int currentCapacity = 0;

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void checkCurrentCapacity() {
        if(currentCapacity == capacity) {
            System.out.println("Port is full");
        }
    }

    public void addItems(int number) {
        for(int i = 0; i < number; i++) {
            System.out.println("Pier number " + i + " created");
            piers.add(new Pier("Pier " + i));
        }
    }
}
