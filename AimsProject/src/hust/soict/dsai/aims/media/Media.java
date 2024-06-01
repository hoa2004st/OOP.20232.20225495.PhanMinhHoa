package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.store.Store;

import javax.naming.LimitExceededException;
import java.util.Comparator;
import java.util.Scanner;

public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean equals(Media other) {
        return this.getTitle().equals(other.getTitle()) && this.getCost() == other.getCost();
    }

    public static void mediaDetailsMenu(Store store, Cart cart) throws LimitExceededException, PlayerException {
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
                store.storeMenu(store, cart);
                break;
        }
    }
}
