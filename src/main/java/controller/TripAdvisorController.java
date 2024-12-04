package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TripAdvsiorService;

@RestController
public class TripAdvisorController {

    TripAdvsiorService tripAdvsiorService;

    @GetMapping("/attractions")
    public String getAttractions(String location){
        return getAttractions(location);
    }



}
