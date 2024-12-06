package com.example.trip.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flightapi")
public class FlightController {

    @GetMapping("/flight-hello")
    public String hello(){
        return "Hello World from Flight Controller";
    }



}
