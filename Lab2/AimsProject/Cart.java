package Lab2.AimsProject;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public void addDigitalVideoDisc (DigitalVideoDisc disc){
        System.out.println("The disc has been added");

    }

    public void removeDigitalVideoDisc (DigitalVideoDisc disc){

    }

    public float totalCost() {
        float result = 0;
        for (DigitalVideoDisc disc : itemOrdered) {
            result += disc.getCost();
        }
        return result;
    }
}
