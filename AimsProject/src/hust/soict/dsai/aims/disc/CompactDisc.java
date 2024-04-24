package hust.soict.dsai.aims.disc;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
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
    public void play() {
        for (Track track : tracks){
            track.play();
        }
    }
}
