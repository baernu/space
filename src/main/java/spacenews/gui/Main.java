package spacenews.gui;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import spacenews.util.I18n;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Main class with extends the Application class from javafx
 */
public class Main extends Application {
	private static Locale locale = new Locale("en");
	private static Stage stage;

	/**
	 * method to set the param for the language
	 * @param locale defines the param for the language
	 */
	public static void setLocale(Locale locale) {
		Main.locale = locale;
	}

	/**
	 * method to get the param for the language
	 * @return the param for the language
	 */
	public static Locale getLocale() {
		return locale;
	}

	/**
	 * method to get the main stage from javafx
	 * @return the main stage
	 */
	public static Stage getStage() {
		return Main.stage;
	}

	/**
	 * method to start the LanguageController and displays the languageView.fxml
	 * @param stage from the javafx Application
	 */
	public void start(Stage stage) {
		FXMLLoader loader1 = null;

		Main.stage = stage;
		LanguageController languageController = new LanguageController();
		try {
			loader1 = new FXMLLoader(getClass().getClassLoader().getResource("languageView.fxml"
				), I18n.getResourceBundle(locale));
			loader1.setController(languageController);
			Parent root = loader1.load();
			Scene scene = new Scene(root, 200, 200);
			stage.setScene(scene);
			stage.show();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * static method to start (to launch) the application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
