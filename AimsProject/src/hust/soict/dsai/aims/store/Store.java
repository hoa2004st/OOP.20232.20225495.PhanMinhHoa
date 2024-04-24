package src.hust.soict.dsai.aims.store;

import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia (Media... items) {
        for (Media item : items) {
            this.itemsInStore.add(item);
            System.out.println("The disc has been added to the store.");
        }

    }
    public void removeMedia(Media... items) {
        for (Media item : items) {
            this.itemsInStore.remove(item);
            System.out.println("The disc has been removed out of the store.");
        }
    }

}
