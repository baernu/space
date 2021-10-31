package ch.bfh.spacenews.api;


import ch.bfh.spacenews.domain.Articles;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class GetNews {
    public static void main(String[] args) {
        try {
            String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

            ObjectMapper objectMapper = new ObjectMapper();

            Articles[] cars2 = objectMapper.readValue(jsonArray, Articles[].class);
            URL url = new URL("file:data/car.json");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}