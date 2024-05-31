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
    public String play() {
        String result = new String();
        result += "Playing track: " + this.getTitle() + "\n";
        result += "Track length: " + this.getLength() + "\n";
        return result;
    }

    public boolean equals(Track other) {
        return (this.getTitle().equals(other.getTitle()) && this.getLength() == other.getLength());
    }
}
