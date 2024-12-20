package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;

    private Store store;
    private Cart cart;
    private CartScreen cartScreen; // Tham chiếu đến cửa sổ CartScreen

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        MenuListener menuListener = new MenuListener(store, cart);
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(menuListener);
        smUpdateStore.add(addBook);
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(menuListener);
        smUpdateStore.add(addCD);
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(menuListener);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(menuListener);
        menu.add(viewStore);
        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(menuListener);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        ButtonListener buttonListener = new ButtonListener(cart);
        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        cart.addActionListener(buttonListener);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> itemsInStore = store.getItemsInStore(); // Lấy danh sách media từ store
        if (itemsInStore != null && !itemsInStore.isEmpty()) {
            for (int i = 0; i < Math.min(9, itemsInStore.size()); i++) {
                Media mediaItem = itemsInStore.get(i);
                MediaStore cell = new MediaStore(mediaItem, cart); // Pass the shared cart instance here
                center.add(cell);
            }
        }
        return center;
    }

    // Button Listener for View Cart
    private class ButtonListener implements ActionListener {
        // Attribute
        private Cart cart;

        // Constructor
        public ButtonListener(Cart cart) {
            super();
            this.cart = cart;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("View cart")) {
                Platform.runLater(() -> new CartScreen(cart));
                setVisible(false);
                dispose();
            }
        }
    }

    // Menu Listener for Menu Option
    private class MenuListener implements ActionListener {
        // Attribute
        private Store store;
        private Cart cart;

        // Constructor
        public MenuListener(Store store, Cart cart) {
            super();
            this.store = store;
            this.cart = cart;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String menu = e.getActionCommand();
            if (menu.equals("Add Book")) {
                new AddBookToStore(store, cart);
                setVisible(false);
                dispose();
            } else if (menu.equals("Add CD")) {
                new AddCDToStore(store, cart);
                setVisible(false);
                dispose();
            } else if (menu.equals("Add DVD")) {
                new AddDVDToStore(store, cart);
                setVisible(false);
                dispose();
            } else if (menu.equals("View store")) {
                new StoreScreen(store, cart);
                setVisible(false);
                dispose();
            } else if (menu.equals("View cart")) {
                new CartScreen(cart);
                setVisible(false);
                dispose();
            }
        }
    }

    public CartScreen getCartScreen() {
        return cartScreen;
    }

    public void setCartScreen(CartScreen cartScreen) {
        this.cartScreen = cartScreen;
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Example media added to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Smile 2", "Horror", "Meanwhile", 100, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Next time do not call me your lover till", "Lover", "Whatsupbro",
                200, 39.99f);
        Book book1 = new Book("My name is Hung", "Horror", 99.99f, new ArrayList<>());
        Book book2 = new Book("Hedspi wa saikou", "Animation", 10.99f, new ArrayList<>());
        Book book3 = new Book("Toi tai gioi ban cung tam", "Science", 19.99f, new ArrayList<>());
        CompactDisc cd1 = new CompactDisc("Quay di quay lai", "Music", "HIEUTHUHAI", 199, 19.99f);
        CompactDisc cd2 = new CompactDisc("Troi em lai", "Music", "Quang Hung MASTERD", 299, 29.99f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(cd1);
        store.addMedia(cd2);

        new StoreScreen(store, cart);

    }
}