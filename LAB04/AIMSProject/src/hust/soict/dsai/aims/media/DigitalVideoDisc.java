package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
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
    
    public void play() {
    	System.out.println("Playing DVD: " + this.getTitle());
    	System.out.println("DVD length: " + this.getLength());
    	}
}
