package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		// TODO Auto-generated constructor stub
		super(1,title,category,cost,length,director);
	}
	public static int nbDigitalVideoDiscs = 0;

    
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + director + " - " + length + " min: " + this.getCost() + " $";
    }
    
    public boolean isMatch(String title1) {
        return this.getTitle().equalsIgnoreCase(title1);
    }
    
    public static int getNextId() {
        return nbDigitalVideoDiscs++;
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
