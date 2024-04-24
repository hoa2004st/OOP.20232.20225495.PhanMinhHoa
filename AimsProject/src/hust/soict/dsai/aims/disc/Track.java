package hust.soict.dsai.aims.disc;

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
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Track other) {
        return (this.getTitle().equals(other.getTitle()) && this.getLength() == other.getLength());
    }
}
