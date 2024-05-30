package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestViewStoreScreen extends Application {
    private static Store store = new Store();
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {

        List<Media> medias = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc(1, "Nhac do cuc hay", "Music", 10.0f, "Tong hop");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 30, 10.0f);
        Book book = new Book(3, "The Alchemist", "Story", 20.0f, "Paulo Coelho");

        CompactDisc cd2 = new CompactDisc(5, "Nhac do cuc hay2", "Music", 10.0f, "Tong hop");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King2", "Animation", "Roger Allers", 30, 10.0f);
        Book book2 = new Book(7, "The Alchemist2", "Story", 20.0f, "Paulo Coelho");

        TestViewStoreScreen.store.addMedia(cd, cd2, dvd, dvd2, book, book2);

        launch(args);
    }
}
