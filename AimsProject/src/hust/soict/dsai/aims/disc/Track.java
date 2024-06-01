package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;


    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
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

    public boolean equals(Track other) {
        return (this.getTitle().equals(other.getTitle()) && this.getLength() == other.getLength());
    }
}
