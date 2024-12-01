package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

public class Store {
    // Declare itemsInStore as a static array to store all Media objects
    public static Media[] itemsInStore = new Media[100]; // Assuming a max of 100 media items
    private int numOfItemsInStore = 0; // Keep track of the number of items in the store
    
    // Method to add media to store
    public void addMedia(Media media) {
        if (numOfItemsInStore < itemsInStore.length) {
            itemsInStore[numOfItemsInStore] = media;
            numOfItemsInStore++;
        } else {
            System.out.println("Store is full! Cannot add more media.");
        }
    }
    
    // Method to remove media from store by title
    public void removeMedia(String title) {
        for (int i = 0; i < numOfItemsInStore; i++) {
            if (itemsInStore[i].getTitle().equalsIgnoreCase(title)) {
                for (int j = i; j < numOfItemsInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numOfItemsInStore - 1] = null;
                numOfItemsInStore--;
                System.out.println("Media " + title + " has been removed.");
                return;
            }
        }
        System.out.println("Media not found.");
    }

    // Method to print the items in the store
    public void printStore() {
        for (int i = 0; i < numOfItemsInStore; i++) {
            System.out.println(itemsInStore[i].getTitle());
        }
    }
    
    // Method to find media by title
    public Media findMediaByTitle(String title) {
        for (int i = 0; i < numOfItemsInStore; i++) {
            if (itemsInStore[i].getTitle().equalsIgnoreCase(title)) {
                return itemsInStore[i];
            }
        }
        return null;
    }
}
