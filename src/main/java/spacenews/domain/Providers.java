package spacenews.domain;


import com.fasterxml.jackson.annotation.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * This class is helper class for the articles class. The deserializer gives the data to the articles class.
 * The articles class needs a nested json which are the providers. In this class these providers are generated.
 */
public class Providers {

    private String id;

    private String provider;

    @JsonCreator
    /**
     * Constructor for the Provider with the param id and the param provider
     */
    public Providers(
            @JsonProperty("id")  String id,
            @JsonProperty("provider") String provider  ) {

        this.id = id;
        this.provider = provider;
    }
    @JsonGetter("id")
    /**
     * method return the id
     */
    public String getId() {
        return id;
    }
    @JsonGetter("provider")
    /**
     * method return the provider
     */
    public String getProvider() {
        return provider;
    }
    @JsonSetter("id")
    /**
     * method sets the id
     */
    public void setId(String id) {
        this.id = id;
    }
    @JsonSetter("provider")
    /**
     * method sets the provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }


}
