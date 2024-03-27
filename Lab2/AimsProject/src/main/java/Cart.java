public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

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
}