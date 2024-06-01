package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }
    public CompactDisc(int id, String title, String category, float cost, String artist) {
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.setArtist(artist);
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track... tracks){
        for (Track track : tracks) {
            this.tracks.add(track);
        }
    }

    public void removeTrack(Track... tracks){
        for (Track track : tracks) {
            this.tracks.remove(track);
        }
    }

    public int getLength(){
        int result = 0;
        for (Track track : this.tracks){
            result += track.getLength();
        }
        return result;
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
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getCost() + "$";
    }
}
