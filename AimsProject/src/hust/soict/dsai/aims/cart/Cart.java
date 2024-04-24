package src.hust.soict.dsai.aims.cart;
import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public String toString(){
        StringBuilder sb = new StringBuilder("***********************CART***********************\n");

        sb.append(String.format("Total cost: %.2f\n", this.totalCost()));
        sb.append("***************************************************");
        return sb.toString();
    }

    public void addMedia(Media... items){
        for (Media item : items) {
            itemsOrdered.add(item);
        }
    }

    public void removeMedia(Media... items){
        for (Media item : items) {
            itemsOrdered.remove(item);
        }
    }

    public float totalCost() {
        float result = 0;
        for (Media item : itemsOrdered) {
            result += item.getCost();
        }
        return result;
    }

    public void print() {
        System.out.println(this);
    }
}
