package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Polymorphism {
	public static void main(String[] args) {
		List <Media> mediae = new ArrayList<Media>();
		Book book1 = new Book(1, "The Great Gatsby", "Fiction", 10.99f);
        Book book2 = new Book(2, "1984", "Dystopian", 12.50f);
        
        // Tạo CompactDisc
        CompactDisc cd1 = new CompactDisc(3, "Back in Black", "Rock", 15.99f, 100, "AC/DC");
        CompactDisc cd2 = new CompactDisc(4, "Thriller", "Pop", 18.00f, 100, "Michael Jackson");

        // Tạo DigitalVideoDisc
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(5, "Inception", "Sci-Fi", 19.99f, 148, "Christopher Nolan");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(6, "The Dark Knight", "Action", 17.99f, 152, "Christopher Nolan");
        
        mediae.add(book1);
        mediae.add(book2);
        mediae.add(dvd1);
        mediae.add(dvd2);
        mediae.add(cd1);
        mediae.add(cd2);
        
        for (Media m : mediae)
        {
        	System.out.println(m.toString());
        }
        
        List<Media> mediaList = new ArrayList<>();

        // Add media items
        mediaList.add(new Book(7, "The Great Gatsby", "Fction", 10.99f));
        mediaList.add(new Book(8, "1984", "Dystopian", 18.99f));
        mediaList.add(new DigitalVideoDisc(9, "Inception", "Sci-Fi", 19.99f, 148, "Christopher Nolan"));
        mediaList.add(new DigitalVideoDisc(10, "Inception", "Sci-Fi", 18.99f, 148, "Christopher Nolan"));
        mediaList.add(new CompactDisc(11, "Thriller", "Pop", 18.00f, 0, "Michael Jackson"));

        // Sort by Title then Cost
        System.out.println("Sorted by Title then Cost:");
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
        mediaList.forEach(media -> System.out.println(media.getTitle() + " - " + media.getCost()));

        // Sort by Cost then Title
        System.out.println("\nSorted by Cost then Title:");
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
        mediaList.forEach(media -> System.out.println(media.getTitle() + " - " + media.getCost()));
    }
}
