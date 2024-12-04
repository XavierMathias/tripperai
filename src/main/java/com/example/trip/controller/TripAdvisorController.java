package com.example.trip.controller;

import com.example.trip.service.TripAdvsiorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class TripAdvisorController {

    TripAdvsiorService tripAdvsiorService;

    @GetMapping("/attractions")
    public String getAttractions(@RequestParam String location){
        return getAttractions(location);
    }





}
