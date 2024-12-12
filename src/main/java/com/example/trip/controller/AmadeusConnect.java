package com.example.trip.controller;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AmadeusConnect {
    private Amadeus amadeus;

    @Value("${flight.api.key}")
    private String apiKey;

    @Value("${flight.api.secret_key}")
    private String apiSecretKey;

    @PostConstruct
    public void init() {
        this.amadeus = Amadeus.builder(apiKey, apiSecretKey).build();
    }

    public Location[] location(String keyword) throws ResponseException {
        Location[] locations = amadeus.referenceData.locations.get(Params.with("keyword", keyword)
                .and("subType", Locations.AIRPORT));
        if (locations.length == 0){
            System.out.println("There's no location");
        }

        return locations;
    }
}
