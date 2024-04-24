package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        anOrder.addMedia(dvd1);
        anOrder.addMedia(dvd2);
        anOrder.addMedia(dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeMedia(dvd1);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

//        System.out.println(anOrder);
    }
}
