package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBER_ORDERED=20;
    private DigitalVideoDisc itemsOrdered[]= new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered;
    public void addDigitalVideoDisc(DigitalVideoDisc disc)
    { 
        if (qtyOrdered<MAX_NUMBER_ORDERED)
        {
            qtyOrdered++;
            itemsOrdered[qtyOrdered-1]=disc;

        }
        else
        {
            System.out.println("The cart is almost full");
        }
    }
//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
//    {
//        for (DigitalVideoDisc disc : dvdList) {
//            if (qtyOrdered < MAX_NUMBER_ORDERED) {
//                itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//                System.out.println("Added: " + disc.getTitle());
//            } else {
//                System.out.println("The cart is almost full. Cannot add: " + disc.getTitle());
//                break;
//            }
//        }
//    }
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBER_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("Added: " + disc.getTitle());
            } else {
                System.out.println("The cart is full. Cannot add: " + disc.getTitle());
                break;
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        if (qtyOrdered<MAX_NUMBER_ORDERED)
        {
            qtyOrdered++;
            itemsOrdered[qtyOrdered-1]=dvd1;

        }
        else
        {
            System.out.println("The cart is almost full");
        }
        if (qtyOrdered<MAX_NUMBER_ORDERED)
        {
            qtyOrdered++;
            itemsOrdered[qtyOrdered-1]=dvd2;

        }
        else
        {
            System.out.println("The cart is almost full");
        }
    }
    public int removeDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if(itemsOrdered[0] ==  null) {
            System.out.println("Your cart is empty!");
            return 0;
        }
        for(int i =0; i < qtyOrdered;i++) {
            if(itemsOrdered[i]==disc) {
                for(int j = i;i<qtyOrdered-1;i++) {
                    itemsOrdered[i] = itemsOrdered[i+1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered--;
                System.out.println("The disc is removed successfully!");
                return 0;
            }
        }
        System.out.println("Not found DVD");
        return 0;
    }

    public float totalCost() {
        float sum = 0.00f;
        for (int i=0;i<qtyOrdered;i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println((i + 1) + ". " + dvd.toString());
            totalCost += dvd.getCost();
        }

        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }

    // Method to search DVDs by ID and print the result
    public void searchById(int id) {
        boolean found = false;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd.getId() == id) {
                System.out.println("Found DVD: " + dvd.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    // Method to search DVDs by title and print the result
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i =0; i < qtyOrdered;i++) {
        	DigitalVideoDisc dvd = itemsOrdered[i];
            if (dvd.isMatch(title)) {
                System.out.println("Found DVD: " + dvd.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }
}
