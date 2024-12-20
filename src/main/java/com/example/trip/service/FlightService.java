package com.example.trip.service;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.example.trip.controller.AmadeusConnect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FlightService {

    private final Gson gson = new Gson();
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final AmadeusConnect amadeusConnect;

    @Autowired
    public FlightService(AmadeusConnect amadeusConnect, ObjectMapper objectMapper) {
        this.amadeusConnect = amadeusConnect;
    }


    //TODO: When possible, switch out the parameter to accept only FlightSearchRequestDTO
    public String searchFlightOffers(String origin, String destination, String departureDate, String returnDate, String adults) throws ResponseException {
        FlightOfferSearch[] flightOfferSearches = amadeusConnect.getFlightOffers(origin, destination, departureDate, adults, returnDate);
        List<FlightOfferSearch> flightOfferSearchList = new ArrayList<>(Arrays.asList(flightOfferSearches));

        for (FlightOfferSearch flightOfferSearch: flightOfferSearchList) {
            FlightOfferSearch.Itinerary[] itineraries = flightOfferSearch.getItineraries();
            System.out.println(itineraries.toString());
        }




        return "";
    }






}
