package com.example.trip.controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.example.trip.dto.LocationsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.amadeus.resources.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flightapi")
public class FlightController {

    @GetMapping("/flight-hello")
    public String hello(){
        return "Hello World from Flight Controller";
    }
    private final AmadeusConnect amadeusConnect;
    private final ObjectMapper objectMapper;
    private StringBuilder sb = new StringBuilder();

    @Autowired
    public FlightController(AmadeusConnect amadeusConnect, ObjectMapper objectMapper) {
        this.amadeusConnect = amadeusConnect;
        this.objectMapper = objectMapper;
    }

    // This will be used for a dropdown menu on form on frontend
    @GetMapping("/locations")
    public String getLocations(@RequestParam String keyword) {

        try {
            // Fetch locations
            Location[] locations = amadeusConnect.location(keyword);
            List<LocationsDTO> locationsDTOList = new ArrayList<>();
            for (Location location : locations) {
                locationsDTOList.add(new LocationsDTO(
                        location.getAddress(),
                        location.getAnalytics(),
                        location.getDistance(),
                        location.getGeoCode(),
                        location.getDetailedName(),
                        location.getIataCode(),
                        location.getName(),
                        location.getSubType(),
                        location.getTimeZoneOffset(),
                        location.getType()
                ));
            }

            return locationsDTOList.stream().map(Object::toString).collect(Collectors.joining("\n"));
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Unable to fetch locations\"}";
        }
    }

    // This will show up as different boxes after the submission is sent
    @GetMapping("/flights")
    public String getFlightOffers(
            @RequestParam (required = true) String originLocation,
            @RequestParam (required = true) String destinationLocation,
            @RequestParam (required = true) String departureDate,
            @RequestParam (required = false) String returnDate,
            @RequestParam (required = true) String adultsNum) throws ResponseException {

        FlightOfferSearch[] flightOfferSearches = amadeusConnect.getFlightOffers(originLocation, destinationLocation, departureDate, adultsNum, returnDate);
        List<FlightOfferSearch> flightOfferSearchList = new ArrayList<>(Arrays.asList(flightOfferSearches));

        return flightOfferSearchList.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }




}
