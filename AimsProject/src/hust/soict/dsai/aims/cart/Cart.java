package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public String toString(){
        StringBuilder sb = new StringBuilder("***********************CART***********************\n");
        sb.append("Ordered Items:");
        int count = 1;
        for (Media media : itemsOrdered) {
            sb.append(count + ". " + media.toString() + "\n");
        }
        sb.append(String.format("Total cost: %.2f\n", this.totalCost()));
        sb.append("***************************************************");
        return sb.toString();
    }

    public void displayCart(){
        int itemNum = 1;
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered){
            System.out.println(itemNum + ". " + media.toString());
            itemNum++;
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
        System.out.println(this);
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

    public Media searchMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        System.out.println("Disc not found in cart");
        return null;
    }
}
