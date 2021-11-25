package spacenews.domain;



import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * This class is the central class for the data. This class gives the structure for the table-view in the gui.
 */
public class Articles {

    private String id;

    private String title;

    private String url;

    private String imageUrl;

    private String newsSite;

    private String summary;

    private String publishedAt;

    private String updatedAt;

    private String featured;

    private Providers launches;

    private Providers events;



     @JsonCreator
     /**
      * Constructor which takes all the elements from id to events.
      */
     public Articles(
             @JsonProperty("id")  String id,
             @JsonProperty("title") String title,
             @JsonProperty("url") String url,
             @JsonProperty("imageUrl")  String imageUrl,
             @JsonProperty("newsSite") String newsSite,
             @JsonProperty("summary") String summary,
             @JsonProperty("publishedAt")  String publishedAt,
             @JsonProperty("updatedAt") String updatedAt,
             @JsonProperty("featured") String featured,
             @JsonProperty("launches")  Providers launches,
             @JsonProperty("events") Providers events

     ) {



         this.id = id;
         this.title = title;
         this.url = url;
         this.imageUrl = imageUrl;
         this.newsSite = newsSite;
         this.summary = summary;
         this.publishedAt = publishedAt;
         this.updatedAt = updatedAt;
         this.featured = featured;
         this.launches = launches;
         this.events = events;

     }


    @JsonCreator
    /**
     * Constructor which takes  not all the elements. The element featured is missing.
     */
    public Articles(
            @JsonProperty("id")  String id,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url,
            @JsonProperty("imageUrl")  String imageUrl,
            @JsonProperty("newsSite") String newsSite,
            @JsonProperty("summary") String summary,
            @JsonProperty("publishedAt")  String publishedAt,
            @JsonProperty("updatedAt") String updatedAt,
            @JsonProperty("launches")  Providers launches,
            @JsonProperty("events") Providers events

    ) {



        this.id = id;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.newsSite = newsSite;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.launches = launches;
        this.events = events;

    }
    @JsonCreator
    /**
     * Constructor which takes  not all the elements. The elements featured, launches and events are missing.
     */
    public Articles(
            @JsonProperty("id")  String id,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url,
            @JsonProperty("imageUrl")  String imageUrl,
            @JsonProperty("newsSite") String newsSite,
            @JsonProperty("summary") String summary,
            @JsonProperty("publishedAt")  String publishedAt,
            @JsonProperty("updatedAt") String updatedAt


    ) {



        this.id = id;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.newsSite = newsSite;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;

    }



    @JsonGetter("id")
    /**
     * return the id
     */
    public String getId() {
        return id;
    }
    @JsonGetter("title")
    /**
     * return the title
     */
    public String getTitle() {
        return title;
    }
    @JsonGetter("url")
    /**
     * return the url
     */
    public String getUrl() {
        return url;
    }
    @JsonGetter("imageUrl")
    /**
     * return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }
    @JsonGetter("newSite")
    /**
     * return the newsSite
     */
    public String getNewsSite() {
        return newsSite;
    }
    @JsonGetter("summary")
    /**
     * return the summary
     */
    public String getSummary() {
        return summary;
    }
    @JsonGetter("publishedAt")
    /**
     * return the publishedAt
     */
    public String getPublishedAt() {
        return publishedAt;
    }
    @JsonGetter("updatedAt")
    /**
     * return the updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }
    @JsonGetter("featured")
    /**
     * return the featured
     */
    public String getFeatured() {
        return featured;
    }
    @JsonGetter("launches")
    /**
     * return the launches
     */
    public Providers getLaunches() {
        return launches;
    }
    @JsonGetter("events")
    /**
     * return the events
     */
    public Providers getEvents() {
        return events;
    }


}