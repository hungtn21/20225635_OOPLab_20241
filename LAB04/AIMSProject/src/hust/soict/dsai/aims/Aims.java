package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Add some initial media to the store
        store.addMedia(new Book(1, "The Great Gatsby", "Fiction", 10.99f));
        store.addMedia(new Book(2, "To Kill a Mockingbird", "Fiction", 12.49f));
        store.addMedia(new Book(3, "1984", "Dystopian", 14.99f));

        store.addMedia(new CompactDisc(4, "Thriller", "Pop", 18.00f, 0, "Michael Jackson"));
        store.addMedia(new CompactDisc(5, "Back in Black", "Rock", 15.99f, 0, "AC/DC"));
        store.addMedia(new CompactDisc(6, "The Dark Side of the Moon", "Progressive Rock", 20.00f, 0, "Pink Floyd"));

        store.addMedia(new DigitalVideoDisc(7, "Inception", "Sci-Fi", 19.99f, 148, "Christopher Nolan"));
        store.addMedia(new DigitalVideoDisc(8, "The Matrix", "Sci-Fi", 16.50f, 136, "The Wachowskis"));
        store.addMedia(new DigitalVideoDisc(9, "The Godfather", "Crime", 25.00f, 175, "Francis Ford Coppola"));


        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    viewCart(scanner);
                    break;
                case 0:
                    exit = true;
                    System.out.print("Good bye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }

        scanner.close();
    }

    private static void viewStore(Scanner scanner) {
        boolean back = false;

        while (!back) {
            store.printStore();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    Media media = store.findMediaByTitle(title);
                    if (media != null) {
                        System.out.println(media);
                        mediaDetails(scanner, media);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the title of the media to add to cart: ");
                    title = scanner.nextLine();
                    media = store.findMediaByTitle(title);
                    if (media != null) {
                        cart.addMedia(media);
                        System.out.println("Added to cart: " + media.getTitle());
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the title of the media to play: ");
                    title = scanner.nextLine();
                    media = store.findMediaByTitle(title);
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 4:
                    viewCart(scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }

    private static void mediaDetails(Scanner scanner, Media media) {
        boolean back = false;

        while (!back) {
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Added to cart: " + media.getTitle());
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }

    private static void updateStore(Scanner scanner) {
        System.out.println("Enter 1 to add a media or 2 to remove a media: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.println("Enter media details (id, title, category, cost): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String title = scanner.nextLine();
            String category = scanner.nextLine();
            float cost = scanner.nextFloat();

            Media media = new Media(id, title, category, cost) {};
            store.addMedia(media);
            System.out.println("Media added to the store.");
        } else if (choice == 2) {
            System.out.println("Enter the title of the media to remove: ");
            String title = scanner.nextLine();
            if (title != null) {
                store.removeMedia(title);
                System.out.println("Media removed from the store.");
            } else {
                System.out.println("Media not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void viewCart(Scanner scanner) {
        boolean back = false;

        while (!back) {
            cart.printCart();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    cart.filterCart(scanner);
                    break;
                case 2:
                    cart.sortCart(scanner);
                    break;
                case 3:
                    System.out.println("Enter the title of the media to remove: ");
                    String title = scanner.nextLine();
                    cart.removeMedia(title);
                    break;
                case 4:
                    System.out.println("Enter the title of the media to play: ");
                    title = scanner.nextLine();
                    Media media = cart.findMediaByTitle(title);
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 5:
                    cart.placeOrder();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }
}
