package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	
	public CompactDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, String director, int length, float cost) {
		// TODO Auto-generated constructor stub
		super(title, category, director, length, cost);
	}

	private String artist;
	private ArrayList<Track> tracks;
	
	public String getArtist() {
		return this.artist;
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
	
	@Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            java.util.Iterator iterator = tracks.iterator();
            Track nextTrack;
            while (iterator.hasNext()) {
            	nextTrack = (Track) iterator.next();
            	try {
            		nextTrack.play();
            	}
            	catch (PlayerException e) {
					throw e;
				}
            }
        	
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}
