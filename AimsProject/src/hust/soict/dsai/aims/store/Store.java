package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

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
    public Media findMedia(String title){
        for (Media item : itemsInStore){
            if (item.getTitle().equals(title)){
                return item;
            }
        }
        return null;
    }
    public void viewStore(){
        int i = 1;
        for (Media item : itemsInStore){
            System.out.println(i + "." + item);
            i++;
        }
    }

}
