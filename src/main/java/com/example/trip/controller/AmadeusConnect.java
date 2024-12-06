package com.example.trip.controller;


import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import org.springframework.beans.factory.annotation.Value;

public enum AmadeusConnect {
    INSTANCE;
    private Amadeus amadeus;
    @Value("${flight.api.key}")
    private String apiKey;
    @Value("${flight.api.secret_key}")
    private String apiSecretKey;
    private AmadeusConnect(){
        this.amadeus = Amadeus
                .builder(apiKey, apiSecretKey)
                .build();
    }

    public Location[] location(String keyword) throws ResponseException {
        return amadeus.referenceData.locations.get(Params.with("keyword", keyword)
                .and("subType", Locations.AIRPORT));
    }
} // end of enum
