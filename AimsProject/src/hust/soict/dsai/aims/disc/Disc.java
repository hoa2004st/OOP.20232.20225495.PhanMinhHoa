package src.hust.soict.dsai.aims.disc;

import src.hust.soict.dsai.aims.media.Media;

public class Disc extends Media {
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    Disc(){
    }
    Disc(int length, String director){
        this.length = length;
        this.director = director;
    }
}
