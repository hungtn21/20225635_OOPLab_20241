package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
        // Create DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 14.99f);

        // Create a Store with a capacity of 5 DVDs
        Store store = new Store(5);

        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Display the DVDs in the store
        store.displayStore();

        // Remove a DVD by ID and display the store again
        store.removeDVD(dvd2.getId()); // Removing the second DVD
        store.displayStore();

        // Try to remove a DVD that doesn't exist
        store.removeDVD(999); // No such DVD ID
    }
}
