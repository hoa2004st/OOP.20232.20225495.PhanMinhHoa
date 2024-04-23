package src.hust.soict.dsai.aims.store;

import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        store.addDVD(dvd1, dvd2);
        store.addDVD(dvd3);

        System.out.println(store.itemsInStore.size());

        store.removeDVD(dvd1);

        System.out.println(store.itemsInStore.size());
    }
}
