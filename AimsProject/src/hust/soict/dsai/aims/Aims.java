package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
//        Cart anOrder = new Cart();
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//
//        anOrder.addMedia(dvd1);
//        anOrder.addMedia(dvd2);
//        anOrder.addMedia(dvd3);
//
//        System.out.println("Total Cost is: ");
//        System.out.println(anOrder.totalCost());
//
//        anOrder.removeMedia(dvd1);
//        System.out.println("Total Cost is: ");
//        System.out.println(anOrder.totalCost());

//        System.out.println(anOrder);

//        List<Media> medias = new ArrayList<Media>();
//        CompactDisc cd = new CompactDisc();
//        cd.setTitle("Nhac do cuc hay");
//        cd.setCategory("Music");
//        cd.setArtist("Tong hop");
//        cd.setCost(10.0f);
//        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 30, 10.0f);
//        Book book = new Book();
//        book.setTitle("The Alchemist");
//        book.setCategory("Story");
//        book.setCost(20.0f);
//
//        medias.add(cd);
//        medias.add(dvd);
//        medias.add(book);
//
//        for (Media m: medias) {
//            System.out.println(m.toString());
//        }
        Store store = new Store();
        Cart cart = new Cart();
        showMenu(store, cart);

    }
    public static void showMenu(Store store, Cart cart){
        System.out.println("Main Menu: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        switch (selection){
            case 1:
                store.viewStore();
                storeMenu(store, cart);
                break;
            case 2:
                System.out.println("Update Store Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Add media");
                System.out.println("2. Remove media");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2");

                int selection1 = sc.nextInt();
                switch (selection1){
                    case 1:
                        System.out.println("Enter media title: ");
                        String inputTitle = sc.nextLine();
                        Media media = store.findMedia(inputTitle);
                        store.addMedia(media);
                        break;
                    case 2:
                        System.out.println("Enter media title: ");
                        String inputTitle1 = sc.nextLine();
                        Media media1 = store.findMedia(inputTitle1);
                        store.removeMedia(media1);
                        break;
                    case 0:
                        showMenu(store, cart);
                        break;
                }
                break;
            case 3:
                cart.displayCart();
                cartMenu(store, cart);
                break;
            case 0:
                break;
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
                mediaDetailsMenu(store, cart);
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
            case 4:
                cartMenu(store, cart);
            case 0:
                showMenu(store, cart);
                break;
        }
    }
    public static void mediaDetailsMenu(Store store, Cart cart) {
        System.out.println("Details Menu: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Enter media title to add to cart: ");
                String inputTitle = sc.nextLine();
                Media media = store.findMedia(inputTitle);
                cart.addMedia(media);
                System.out.println("Current number of items in cart: " + cart.itemsOrdered.size());
                mediaDetailsMenu(store, cart);
                break;
            case 2:
                System.out.println("Enter DVD/CD title to play: ");
                String inputTitle1 = sc.nextLine();
                Media media1 = store.findMedia(inputTitle1);
                if (media1 instanceof DigitalVideoDisc){
                    ((DigitalVideoDisc) media1).play();
                } else if ( media1 instanceof CompactDisc){
                    ((CompactDisc) media1).play();
                }
                mediaDetailsMenu(store, cart);
                break;
            case 0:
                storeMenu(store, cart);
                break;
        }
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
                storeMenu(store, cart);
                break;
        }
    }
}
