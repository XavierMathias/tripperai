package com.example.trip.controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
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

    @GetMapping("/locations")
    public String getLocations(@RequestParam String keyword) {

        try {
            // Fetch locations
            Location[] locations = amadeusConnect.location(keyword);

            ArrayList<Location> locationArray = new ArrayList<>(Arrays.asList(locations));
            for (Location location : locationArray) {
                sb.append(location.toString()).append("\n");
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Unable to fetch locations\"}";
        }
    }




}
