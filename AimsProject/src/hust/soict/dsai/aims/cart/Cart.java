package src.hust.soict.dsai.aims.cart;
import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public String toString(){
        String result = "***********************CART***********************\n";
        result = result.concat("Ordered Items:\n");
        for (int i = 1; i <= this.qtyOrdered; i++) {
            result = result.concat(String.format("%d.DVD - %s - %s - %s - %s: %s $\n", i, itemOrdered[i-1].getTitle(), itemOrdered[i-1].getCategory(), itemOrdered[i-1].getDirector(), itemOrdered[i-1].getLength(), itemOrdered[i-1].getCost()));
        }
        result = result.concat(String.format("Total cost: %.2f\n", this.totalCost()));
        result = result.concat("***************************************************");
        return result;
    }
    public void addDigitalVideoDisc (DigitalVideoDisc disc){
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("Cannot add the disc! The cart is full.");
        }
        else {
            this.itemOrdered[this.qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added.");
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full.");
            } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 2) {
                System.out.println("The cart is almost full.");
            }
        }
    }

    //    public void addDigitalVideoDisc (DigitalVideoDisc[] dvdList){
//        for (DigitalVideoDisc dvd : dvdList) {
//            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
//                System.out.println("Cannot add the disc! The cart is full.");
//            }
//            else {
//                this.itemOrdered[this.qtyOrdered] = dvd;
//                qtyOrdered += 1;
//                System.out.println("The disc has been added.");
//                if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
//                    System.out.println("The cart is full.");
//                } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 2) {
//                    System.out.println("The cart is almost full.");
//                }
//            }
//        }
//    }
    public void addDigitalVideoDisc (DigitalVideoDisc... discs) {
        for (DigitalVideoDisc disc : discs) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("Cannot add the disc! The cart is full.");
            }
            else {
                this.itemOrdered[this.qtyOrdered] = disc;
                qtyOrdered += 1;
                System.out.println("The disc has been added.");
                if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                    System.out.println("The cart is full.");
                } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 2) {
                    System.out.println("The cart is almost full.");
                }
            }
        }
    }

    public void addDigitalVideoDisc (DigitalVideoDisc disc1, DigitalVideoDisc disc2){
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("Cannot add the disc! The cart is full.");
        }
        else {
            this.itemOrdered[this.qtyOrdered] = disc1;
            qtyOrdered += 1;
            System.out.println("The disc has been added.");
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("Cannot add the disc! The cart is full.");
            }
            else {
                this.itemOrdered[this.qtyOrdered] = disc2;
                qtyOrdered += 1;
                System.out.println("The disc has been added.");
                if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                    System.out.println("The cart is full.");
                } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 2) {
                    System.out.println("The cart is almost full.");
                }
            }
        }
    }

    public void removeDigitalVideoDisc (DigitalVideoDisc disc){
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemOrdered[i] == disc) {
                for (int j = i; j < MAX_NUMBERS_ORDERED - 1; j++) {
                    this.itemOrdered[j] = this.itemOrdered[j + 1];
                }
                this.itemOrdered[MAX_NUMBERS_ORDERED - 1] = null;
                qtyOrdered -= 1;
                System.out.println("The disc has been removed.");
                return;
            }
        }
        System.out.println("This disc is not in the cart!");
        return;
    }

    public float totalCost() {
        float result = 0;
        for (DigitalVideoDisc disc : itemOrdered) {
            if (disc != null) {
                result += disc.getCost();
            }
        }
        return result;
    }

    public void print() {
        System.out.println(this);
    }
}
