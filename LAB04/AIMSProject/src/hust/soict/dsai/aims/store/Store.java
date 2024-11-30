package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int numItems;

    // Constructor to initialize the store with a specified size
    public Store(int size) {
        itemsInStore = new DigitalVideoDisc[size];
        numItems = 0;
    }

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore[numItems] = dvd;
        numItems++;
        System.out.println("DVD " + dvd.toString() + " added to the store.");
    }

    // Method to remove a DVD from the store by its ID
    public void removeDVD(int id) {
        boolean found = false;
        for (int i = 0; i < numItems; i++) {
            if (itemsInStore[i].getId() == id) {
                // Shift the remaining DVDs to the left to remove the DVD
                for (int j = i; j < numItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numItems - 1] = null; // Nullify the last item
                numItems--;
                found = true;
                System.out.println("DVD with ID " + id + " removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    // Method to display all DVDs in the store
    public void displayStore() {
        if (numItems == 0) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("********** DVDs in Store **********");
            for (int i = 0; i < numItems; i++) {
                System.out.println(itemsInStore[i].toString());
            }
            System.out.println("***********************************");
        }
        //hi
    }
}
