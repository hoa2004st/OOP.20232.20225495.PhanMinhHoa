package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

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
    public static void storeMenu(Store store, Cart cart){
        System.out.println("Store Menu: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        switch (selection){
            case 1:
                System.out.println("Enter media title: ");
                String inputTitle = sc.nextLine();
                Media media = store.findMedia(inputTitle);
                System.out.println(media);
                media.mediaDetailsMenu(store, cart);
                break;
            case 2:
                System.out.println("Enter media title: ");
                String inputTitle1 = sc.nextLine();
                Media media1 = store.findMedia(inputTitle1);
                store.addMedia(media1);
                System.out.println("Added");
                storeMenu(store, cart);
                break;
            case 3:
                System.out.println("Enter DVD/CD title to play: ");
                String inputTitle2 = sc.nextLine();
                Media media2 = store.findMedia(inputTitle2);
                if (media2 instanceof DigitalVideoDisc){
                    ((DigitalVideoDisc) media2).play();
                } else if ( media2 instanceof CompactDisc){
                    ((CompactDisc) media2).play();
                }
                storeMenu(store, cart);
                break;
            case 4: cart.cartMenu(store, cart);
            case 0:
                Aims.showMenu(store, cart);
                break;
        }
    }
}
