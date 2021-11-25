package spacenews.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * This class displays the static of each article
 */
public class StatisticsController {

    private final NewsListController newsListController;

    StringProperty totalArticles = new SimpleStringProperty("0");
    StringProperty totalItems = new SimpleStringProperty("0");
    StringProperty totalProviders = new SimpleStringProperty("0");

    /**
     * Constructor which takes a reference from the NewsListController
     * @param newsListController: reference to the NewsListController, to get
     * the values for the statistic.
     */
    public StatisticsController(NewsListController newsListController) {
        this.newsListController = newsListController;

    }

    @FXML
    private TextField items;

    @FXML
    private TextField providers;

    @FXML
    private TextField total;



    @FXML
    /**
     * method to initialize fxml. In this method the fxml variables are bind to the generated statistic values
     * in the NewsControllerList class.
     */
    public void initialize() {
        totalArticles.setValue(String.valueOf(newsListController.getCountArticles()));
        totalItems.setValue(String.valueOf(newsListController.getCountItems()));

        total.textProperty().bindBidirectional(totalArticles);
        items.textProperty().bind(totalItems);
        totalProviders.setValue(String.valueOf(newsListController.getCountProvider()));
        providers.textProperty().bind(totalProviders);

    }

}

