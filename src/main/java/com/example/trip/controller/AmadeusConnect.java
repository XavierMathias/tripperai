package com.example.trip.controller;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.FlightOfferSearch;
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

    // Returns list of locations based on keyword, along with details of local time, airport IATA Codes, etc.
    public Location[] location(String keyword) throws ResponseException {
        Location[] locations = amadeus.referenceData.locations.get(Params.with("keyword", keyword)
                .and("subType", Locations.AIRPORT));
        if (locations.length == 0){
            System.out.println("There's no location");
        }



        return locations;
    }

    //
    public FlightOfferSearch[] getFlightOffers(String origin, String destination, String departDate, String adults, String returnDate) throws ResponseException{
        return amadeus.shopping.flightOffersSearch.get(
                Params.with("originLocationCode", origin)
                        .and("destinationLocationCode", destination)
                        .and("departureDate", departDate)
                        .and("returnDate", returnDate)
                        .and("adults", adults)
                        .and("max", 3)); // Adding parameter "max" allows to limit the number of flight offers returned by API

    }

}
