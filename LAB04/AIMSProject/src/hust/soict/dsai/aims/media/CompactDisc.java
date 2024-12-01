package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	
	public CompactDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		// TODO Auto-generated constructor stub
	}

	private String artist;
	private ArrayList<Track> tracks;
	
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the list!");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" added successfully.");
        }
    }
	public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + director + " - " + artist + " - " + length + " min: " + this.getCost() + " $";
    }
    // Method to remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" removed successfully.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" does not exist in the list.");
        }
    }

	public int getLength()
	{
		int cnt=0;
		for (Track track : tracks)
		{
			cnt+=track.getLength();
		}
		return cnt;
	}
	
	public void play() {
		for (Track track : tracks) 
		{
			track.play();
		}
	}
}
