package spacenews.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import spacenews.api.GetNews;
import spacenews.domain.NewsType;
import spacenews.util.I18n;
import java.io.IOException;
import java.util.MissingResourceException;

/**
 * This class is a Controller class and displays the different types of information to choose.
 * And then starts the NewsListController.
 */
public class NewsController {

    private final GetNews getNews = new GetNews();
    private NewsType newsType;


    @FXML
    private AnchorPane root;
    
    @FXML
    private Button articles;

    @FXML
    private Button blogs;

    @FXML
    private Button exitHome;



    @FXML
    private Button reports;


    @FXML
    /**
     * method to exit the actual application
     */
    void exit(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    /**
     * method to go to the specific type of message: Articles
     * Loading the News Articles from the rest api
     */
    void goToArticles(ActionEvent event)  {
        try {
            newsType = NewsType.Article;
            getNews.load(NewsType.Article);
            control();
        } catch (MissingResourceException e) {
            e.printStackTrace();
        }

    }

    @FXML
    /**
     * method to go to the specific type of message: Blogs
     * Loading the Blogs from the rest api
     */
    void goToBlogs(ActionEvent event) {
        try {
            newsType = NewsType.Blog;
            getNews.load(NewsType.Blog);
            control();
        } catch (MissingResourceException e) {
            e.printStackTrace();
        }
    }


    @FXML
    /**
     * method to go to the specific type of message: Reports
     * Loading the Reports from the rest api
     */
    void goToReports(ActionEvent event)  {
        try {
            newsType = NewsType.Report;
            getNews.load(NewsType.Report);
            control();
        } catch (MissingResourceException e) {
            e.printStackTrace();
        }

    }

    /**
     * method which load the NewsListController with its resource newsView.fxml.
     * Gives the NewsListController a reference to the loaded news.
     */
    public void control()  {

        try {
            NewsListController newsListController = new NewsListController(getNews, this);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("newsView.fxml"), I18n.getResourceBundle(Main.getLocale()));
            loader.setController(newsListController);
            Parent root = loader.load();
            Scene scene = new Scene(root, 500, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (MissingResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the type of news
     */
    public NewsType getNewsType() {
        return this.newsType;
    }
}
