package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}
	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName))
		{
			System.out.println("Author already exists in the list!");
		}
		else 
		{
			authors.add(authorName);
			System.out.println("Author " + authorName + " has been added successfully!");
		}
	}
	public void removeAuthor(String authorName)
	{
		if (authors.contains(authorName))
		{
			authors.remove(authorName);
            System.out.println("Author '" + authorName + "' has been removed.");
		}
		else 
		{
			System.out.println("Author '" + authorName + "' does not exist in the list!");
		}
	}
	public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getAuthors() + " min: " + this.getCost() + " $";
    }
}
