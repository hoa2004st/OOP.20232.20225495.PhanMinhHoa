package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;

public class DigitalVideoDisc extends Media implements Playable{
    private String director;
    private int length;

    private static int nbDigitalVideoDiscs = 0;

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length) {
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.setLength(length);
    }

    public DigitalVideoDisc(String title) {
        this.setTitle(title);
        nbDigitalVideoDiscs += 1;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        nbDigitalVideoDiscs += 1;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.setCost(cost);
        nbDigitalVideoDiscs += 1;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
        this.setCost(cost);
        nbDigitalVideoDiscs += 1;
        this.setId(nbDigitalVideoDiscs);
    }

    @Override
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
            String result = new String();
            result = result + "Playing DVD: " + this.getTitle() + "\n";
            result = result + "DVD length: " + this.getLength() + "\n";
            return result;
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

    }

    public String toString(){
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ":00 - " + getCost() + "$";
    }
}
