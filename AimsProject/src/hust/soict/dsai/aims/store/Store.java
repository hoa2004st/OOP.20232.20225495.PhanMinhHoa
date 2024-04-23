package src.hust.soict.dsai.aims.store;

import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;

public class Store {
    public ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
    public void addDVD (DigitalVideoDisc... discs) {
        for (DigitalVideoDisc disc : discs) {
            this.itemsInStore.add(disc);
            System.out.println("The disc has been added to the store.");
        }

    }
    public void removeDVD(DigitalVideoDisc... discs) {
        for (DigitalVideoDisc disc : discs) {
            this.itemsInStore.remove(disc);
            System.out.println("The disc has been removed out of the store.");
        }
    }

}
