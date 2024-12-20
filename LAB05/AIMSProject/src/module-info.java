/**
 * 
 */
/**
 * 
 */
module AIMSProject {
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.swing;
	opens hust.soict.dsai.aims.screen to javafx.graphics, javafx.fxml;
	opens hust.soict.dsai.aims.media to javafx.base; 
    // Xuất package để bên ngoài sử dụng được
    exports hust.soict.dsai.aims.screen;
}