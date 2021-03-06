package spacenews.api;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import spacenews.domain.Articles;
import spacenews.domain.ArticlesDeserializer;
import spacenews.domain.NewsType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class takes the data from a rest api and generates with a deserializer members in
 * a java class.
 */
public class GetNews {

    private List<Articles> articles = new ArrayList<>();

    /**
     * This method make an HTTP Request by a specific server. The Deserializer from
     * the ArticlesDeseializer class map then this data into a java class. This class
     * is the Articles class.
     * @param newsType is an enum which indicate the type of the message
     */
    public void load(NewsType newsType) {

        String input = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response;
        HttpGet request = null;
        try {
            switch (newsType) {
                case Article -> request = new HttpGet("https://api.spaceflightnewsapi.net/v3/articles");
                case Blog -> request = new HttpGet("https://api.spaceflightnewsapi.net/v3/blogs");
                case Report -> request = new HttpGet("https://api.spaceflightnewsapi.net/v3/reports");
            }

            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                input = EntityUtils.toString(entity);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();

        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            SimpleModule module = new SimpleModule();
            module.addDeserializer(Articles.class, new ArticlesDeserializer());
            objectMapper.registerModule(module);
            articles = objectMapper.readValue(input, new TypeReference<List<Articles>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return the list of articles
     */
    public List<Articles> getArticles() {
        return this.articles;
    }

}