package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + title);
            System.out.println("Track length : " + length);
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
	
	@Override
	public boolean equals(Object obj) {
		Track obj1 = (Track) obj;
		return title.equals(obj1.title) && length==obj1.length;
	}
}
