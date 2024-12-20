package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCDToStore extends AddMediaToStoreScreen {
    // Attribute
    protected JTextField tfDirector;
    protected JTextField tfLength;

    // Constructor

    public AddCDToStore(Store store, Cart cart) {
        super(store, cart, "Add CD", "Add CD to Store");
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        tfDirector = new JTextField(10);
        tfLength = new JTextField(10);
        center.setLayout(new GridLayout(6, 2, 2, 2));
        addInputRow(center, "Title", tfTitle);
        addInputRow(center, "Category", tfCategory);
        addInputRow(center, "Cost", tfCost);
        addInputRow(center, "Director", tfDirector);
        addInputRow(center, "Length", tfLength);
        return center;
    }

    public Media createMedia() {
        return new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText()));
    }
}