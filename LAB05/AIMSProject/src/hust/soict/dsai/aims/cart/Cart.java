package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public float totalCost() {
        float sum = 0.00f;
        for (Media item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }
    public void addMedia(Media item)
    {
    	if (itemsOrdered.contains(item))
    	{
    		System.out.println("Item has already been added");
    	}
    	else 
    	{
			itemsOrdered.add(item);
		}
    }
    public void removeMedia(String title) {
        Media toRemove = findMediaByTitle(title);
        if (toRemove != null) {
            itemsOrdered.remove(toRemove);
            System.out.println("Removed " + title + " from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; // Return null if not found
    }
    public void printCart() {
        System.out.println("CART ITEMS:");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
    }
    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
        } else {
            System.out.println("Order placed successfully!");
            itemsOrdered.clear();
        }
    }
    public void filterCart(Scanner scanner) {
        System.out.println("Filter by: 1. ID 2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.println("Enter ID to filter:");
            int id = scanner.nextInt();
            scanner.nextLine();
            for (Media media : itemsOrdered) {
                if (media.getId() == id) {
                    System.out.println(media);
                }
            }
        } else if (choice == 2) {
            System.out.println("Enter Title to filter:");
            String title = scanner.nextLine();
            for (Media media : itemsOrdered) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    System.out.println(media);
                }
            }
        } else {
            System.out.println("Invalid filter option.");
        }
    }

    // Sort the cart
    public void sortCart(Scanner scanner) {
        System.out.println("Sort by: 1. Title 2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
        } else if (choice == 2) {
            itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
        } else {
            System.out.println("Invalid sort option.");
        }
        System.out.println("Cart sorted successfully!");
    }
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
    public void clear() {
        itemsOrdered.clear();
    }
//    public void sortByTitleCost() {
//        Collections.sort(itemsOrdered, new MediaComparatorByTitleCost());
//    }
//
//    public void sortByCostTitle() {
//        Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
//    }
//
//    public void displayCart() {
//        for (Media media : itemsOrdered) {
//            System.out.println(media.getTitle() + " - " + media.getCost() + "$");
//        }
//    }
//    public void printCart() {
//        System.out.println("***********************CART***********************");
//        System.out.println("Ordered Items:");
//
//        float totalCost = 0;
//        for (int i = 0; i < qtyOrdered; i++) {
//            DigitalVideoDisc dvd = itemsOrdered[i];
//            System.out.println((i + 1) + ". " + dvd.toString());
//            totalCost += dvd.getCost();
//        }
//
//        System.out.println("Total cost: " + totalCost + " $");
//        System.out.println("***************************************************");
//    }
//
//    // Method to search DVDs by ID and print the result
//    public void searchById(int id) {
//        boolean found = false;
//        for (DigitalVideoDisc dvd : itemsOrdered) {
//            if (dvd.getId() == id) {
//                System.out.println("Found DVD: " + dvd.toString());
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            System.out.println("No DVD found with ID: " + id);
//        }
//    }
//
//    // Method to search DVDs by title and print the result
//    public void searchByTitle(String title) {
//        boolean found = false;
//        for (int i =0; i < qtyOrdered;i++) {
//        	DigitalVideoDisc dvd = itemsOrdered[i];
//            if (dvd.isMatch(title)) {
//                System.out.println("Found DVD: " + dvd.toString());
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("No DVD found with title: " + title);
//        }
//    }
}
