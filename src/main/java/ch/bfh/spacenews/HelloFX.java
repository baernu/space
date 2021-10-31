/*
 * Project and Training 2: Space News - Computer Science, Berner Fachhochschule
 */
package ch.bfh.spacenews;

import ch.bfh.spacenews.control.NewsController;
import ch.bfh.spacenews.util.I18n;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Locale;

/**
 * Dummy application class demonstrating a JavaFX application.
 */
public class HelloFX extends Application {

	/**
	 * Start method called by the JavaFX framework upon calling launch().
	 *
	 * @param stage a (default) stage provided by the framework
	 */
	@Override
	public void start(Stage stage) throws Exception {
		/*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		stage.setTitle("Space News App");
		stage.setScene(new Scene(root, 640, 480));
		stage.show();*/


		/*final int width = 640;
		final int height = 480;
		String javaVersion = System.getProperty("java.version");
		String javafxVersion = System.getProperty("javafx.version");
		Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		Scene scene = new Scene(new StackPane(l), width, height);
		stage.setScene(scene);
		stage.show();*/

		try {
			Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//			NewsController newsController = new NewsController();
//			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("newsView.fxml"
//			));
//			), I18n.getResourceBundle(new Locale("labels","de")));
//			loader.setController(newsController);
//			Parent root = loader.load();
			Scene scene = new Scene(root, 500, 350);
			URL url = getClass().getClassLoader().getResource("application.css");
			scene.getStylesheets().add(url.toExternalForm());
			stage.setOnCloseRequest(e -> {
				Platform.exit();
			});
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main entry point of the application.
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch();
	}

}
