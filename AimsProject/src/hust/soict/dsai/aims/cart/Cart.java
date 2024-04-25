package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
    public static void cartMenu(Store store, Cart cart) {
        System.out.println("Cart Menu: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Filtered");
                break;
            case 2:
                System.out.println("Sort Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. By title");
                System.out.println("2. By cost");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 1-2");

                int selection1 = sc.nextInt();
                switch (selection1){
                    case 1:
                        Collections.sort(cart.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
                        break;
                    case 2:
                        Collections.sort(cart.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
                        break;
                }
                cartMenu(store, cart);
                break;
            case 3:
                System.out.println("Enter media title: ");
                String inputTitle = sc.nextLine();
                Media media = cart.searchMediaByTitle(inputTitle);
                cart.removeMedia(media);
                System.out.println("Removed");
                cartMenu(store, cart);
                break;
            case 4:
                System.out.println("Enter DVD/CD title to play: ");
                String inputTitle1 = sc.nextLine();
                Media media1 = store.findMedia(inputTitle1);
                if (media1 instanceof DigitalVideoDisc){
                    ((DigitalVideoDisc) media1).play();
                } else if ( media1 instanceof CompactDisc){
                    ((CompactDisc) media1).play();
                }
                cartMenu(store, cart);
                break;
            case 5:
                System.out.println("Order created");
                cart.itemsOrdered.clear();
                break;
            case 0:
                store.storeMenu(store, cart);
                break;
        }
    }
}
