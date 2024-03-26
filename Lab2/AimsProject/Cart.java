package Lab2.AimsProject;

import java.util.Arrays;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.qtyOrdered; i++){
            String line = String.valueOf(i + 1).concat(("\t"));
            line = line.concat(String.valueOf(this.itemOrdered[i].getTitle())).concat("\t");
            line = line.concat(String.valueOf(this.itemOrdered[i].getCost())).concat("\t\n");
            result = result.concat(line);
        }
        String lastLine = "The total cost is: ".concat(String.valueOf(this.totalCost()));
        return result.concat(lastLine);
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

    public boolean removeDigitalVideoDisc (DigitalVideoDisc disc){
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemOrdered[i] == disc) {
                for (int j = i; j < MAX_NUMBERS_ORDERED - 1; j++) {
                    this.itemOrdered[j] = this.itemOrdered[j + 1];
                }
                this.itemOrdered[MAX_NUMBERS_ORDERED - 1] = null;
                qtyOrdered -= 1;
                System.out.println("The disc has been removed.");
                return true;
            }
        }
        System.out.println("This disc is not in the cart!");
        return false;
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

    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.print("\nTotal Cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println(anOrder);
    }
}
