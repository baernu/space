package spacenews.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import spacenews.util.I18n;
import java.io.IOException;
import java.util.Locale;

/**
 * Controller class for the language.
 */
public class LanguageController {

    @FXML
    /**
     * method which sets the language to english
     */
    void setEnglish(ActionEvent event) {
        Main.setLocale(new Locale("en"));
        run();

    }

    @FXML
    /**
     * method which sets the language to german
     */
    void setGerman(ActionEvent event) {
        Main.setLocale(new Locale("de"));
        run();
    }

    /**
     * method which load the NewsController with its resource news.fxml. The origin stage from the Main class
     * show then the application.
     */
    public void run() {
        try {
            NewsController newsController = new NewsController();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("news.fxml"
            ), I18n.getResourceBundle(Main.getLocale()));
            loader.setController(newsController);
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 500);
            Main.getStage().setScene(scene);
            Main.getStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
