package com.example.trip.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


@Service
public class TripAdvsiorService {

    @Value("${advisor.api.key}")
    private String apiKey = "AC36F2D3EE3A473ABABED0ACA21906FB";
    @Value("${advisor.api.url}")
    private String apiUrl;

    public String getActivities(String location) throws IOException {
        System.out.println("now in getActivities method");
        //String locationName = locationSplitter(location);
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.content.tripadvisor.com/api/v1/location/search?key="+apiKey+"&searchQuery="+location+"&language=en")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Referer", "http://tripper.ltd/")
                .build();



        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string(); // storing JSON string
                System.out.println("Here is the json response " + jsonResponse);

                return jsonResponse;
            } else {
                throw new IOException("Error just came up: " + response.code());
            }
        }

    }

    private String locationSplitter(String location){
        ArrayList<String> locationName = new ArrayList<>(Arrays.asList(location.split("\\s+")));
        String lastCityName = locationName.get(locationName.size() - 1); // capturing the last element
        String query = "";

        for (String word : locationName) {
            if (word.equals(lastCityName)) {
                query = query.concat(word);
                break;
            } else {
                query = query.concat(word + "%" + "20");
                System.out.println(query);
            }
        }

        return query;
    }

} // end of class
