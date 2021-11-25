package spacenews.gui;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import spacenews.api.GetNews;
import spacenews.domain.Articles;
import spacenews.domain.Providers;
import spacenews.util.I18n;
import java.io.IOException;
import java.util.Iterator;
import java.util.MissingResourceException;

/**
 * This class is a Controller class and its display the application in form af a ListView.
 */
public class NewsListController {
    private  final GetNews getNews;
    private Iterator<Articles> iterator;
    private final NewsController newsController;
    private Articles actualIerator;
    private ListProperty<String> listProperty = new SimpleListProperty<>();
    private static int count = 1;
    private int countArticles;
    private int countItems ;
    private int countProvider = 0;

    @FXML
    private AnchorPane root1;

    @FXML
    private ListView<String> listView;



    @FXML
    private HBox hBox ;

    @FXML
    private VBox vBox;

    @FXML
    /**
     * method to initialize fxml. For the first time the nextList() call displays the first ListView
     */
    public void initialize() throws IOException {

        nextList((iterator));


    }

    /**
     * constructor
     * @param getNews: reference to the data from the rest api
     * @param newsController: reference to the NewsController
     * the variable countArticles count the sum of the articles
     */
    public NewsListController(GetNews getNews, NewsController newsController)  {

        this.newsController = newsController;
        this.getNews = getNews;
        countArticles = getNews.getArticles().size();
        iterator = getNews.getArticles().iterator();
        listView = new ListView<>();
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


    }


    /**
     * method to display the next ListView element of type Articles
     * @param iterator: Iterator of type Articles
     *
     */
    private void nextList(Iterator<Articles> iterator)  {
        try {
            String launchesId = null;
            String launchesP = null;
            String eventsId = null;
            String eventsP = null;
            Providers launches = null;
            Providers events = null;
            actualIerator = iterator.next();
            String id = "id: " + actualIerator.getId();
            String title = "title: " + actualIerator.getTitle();
            String url = "url: " + actualIerator.getUrl();
            String imageUrl = "imageUrl: " + actualIerator.getImageUrl();
            String newsSite = "newsSite: " + actualIerator.getNewsSite();
            String summary = "summary: " + actualIerator.getSummary();
            String publishedAt = "publishedAt: " + actualIerator.getPublishedAt();
            String updatedAt = "updatedAT: " + actualIerator.getUpdatedAt();
            String featured = "featured: " + actualIerator.getFeatured();
            if (actualIerator.getLaunches() != null) {
                launches = actualIerator.getLaunches();
            }
            if (launches != null) {
                if (launches.getId() != null) {
                    launchesId = "launches id: " + launches.getId();
                    launchesP = "launches provider: " + launches.getProvider();
                    countProvider++;
                }
            }

            if (actualIerator.getEvents() != null) {
                events = actualIerator.getEvents();
            }
            if (events != null) {
                if (events.getId() != null) {
                    eventsId = "events id: " + events.getId();
                    eventsP = "events provider: " + events.getProvider();
                    countProvider++;
                }
            }


            ObservableList<String> items = FXCollections.observableArrayList(
                id, title, url, imageUrl, newsSite, summary, publishedAt, updatedAt, featured,
                launchesId, launchesP, eventsId, eventsP);
            listProperty.set(items);
            listView.itemsProperty().bind(listProperty);

            countItems = items.size();
        } catch (MissingResourceException e) {
            e.printStackTrace();
        }


    }

    @FXML
    /**
     * method to exit the actual application
     */
    void doExit(ActionEvent event) {
        ((Stage) root1.getScene().getWindow()).close();
    }

    @FXML
    /**
     * method to go to the home application
     */
    void doHome(ActionEvent event) {
        ((Stage) root1.getScene().getWindow()).close();
    }



    @FXML
    /**
     * method to display the next ViewList
     */
    void doNext(ActionEvent event)  {
        try {
            if (iterator.hasNext()) {
                nextList(iterator);
            }
        } catch (MissingResourceException e) {
            e.printStackTrace();
        }


    }

    @FXML
    /**
     * method to refresh the data from the rest api
     */
    void doRefresh(ActionEvent event) {
        getNews.load(newsController.getNewsType());
        iterator = getNews.getArticles().iterator();

    }

    /**
     *
     * @return the sum value of articles
     */
    public int getCountArticles() {
        return countArticles;
    }

    /**
     *
     * @return the sum value of items in a specific article
     */
    public int getCountItems() {
        return countItems;
    }

    /**
     *
     * @return the sum value of Providers in a specific article
     */
    public int getCountProvider() {
        return countProvider;
    }

    /**
     * method to start the StatisticController with its resource statisticsView.fxml.
     * @param event: action element from javafx
     */
    @FXML
    void doStatistics(ActionEvent event)  {
        try {
            StatisticsController statisticsController = new StatisticsController(this);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("statisticsView.fxml"), I18n.getResourceBundle(Main.getLocale()));
            loader.setController(statisticsController);
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (MissingResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
