package com.example.trip.controller;

import com.example.trip.service.TripAdvsiorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class TripAdvisorController {

    private final TripAdvsiorService tripAdvsiorService;
    public TripAdvisorController(TripAdvsiorService tripAdvsiorService) {
        this.tripAdvsiorService = tripAdvsiorService;
    }

    @GetMapping("/attractions")
    public String getAttractions(@RequestParam String location) throws IOException {
        System.out.println("at getAttractions method");
        return tripAdvsiorService.getActivities(location);
    }





}
