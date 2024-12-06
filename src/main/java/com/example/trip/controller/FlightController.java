package com.example.trip.controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flightapi")
public class FlightController {

    @GetMapping("/flight-hello")
    public String hello(){
        return "Hello World from Flight Controller";
    }

    public Location[] locations(@RequestParam(required=true) String keyword) throws ResponseException {
        return AmadeusConnect.INSTANCE.location(keyword);
    }



}
