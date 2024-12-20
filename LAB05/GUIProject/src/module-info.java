/**
 * 
 */
/**
 * 
 */
module GUIProject {
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.controls;
	opens hust.soict.dsai.javafx to javafx.graphics, javafx.fxml;

    // Xuất package để bên ngoài sử dụng được
    exports hust.soict.dsai.javafx;
}