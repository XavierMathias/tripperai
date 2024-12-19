package com.example.trip.dto;

import com.amadeus.resources.Location;

public class LocationsDTO {

    private Location.Address address;
    private Location.Analytics analytics;
    private Location.Distance distance;
    private Location.GeoCode geoCode;
    private double revelance;
    private String detailedName, iataCode, name, subtype, timezoneOffset, type;

    public LocationsDTO(Location.Address address, Location.Analytics analytics, Location.Distance distance, Location.GeoCode geoCode, String detailedName, String iataCode, String name, String subtype, String timezoneOffset, String type) {
        this.address = address;
        this.analytics = analytics;
        this.distance = distance;
        this.geoCode = geoCode;
        this.detailedName = detailedName;
        this.iataCode = iataCode;
        this.name = name;
        this.subtype = subtype;
        this.timezoneOffset = timezoneOffset;
        this.type = type;
    }

    @Override
    public String toString(){
        String message = "Name: " + getName() + "\nIATA Code: " + getIataCode() + "\nDetailed name: " + getDetailedName() + "\n";
        return message;
    }

    public double getRevelance() {
        return revelance;
    }

    public void setRevelance(double revelance) {
        this.revelance = revelance;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(String timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location.Address getAddress() {
        return address;
    }

    public void setAddress(Location.Address address) {
        this.address = address;
    }

    public Location.Analytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(Location.Analytics analytics) {
        this.analytics = analytics;
    }

    public Location.Distance getDistance() {
        return distance;
    }

    public void setDistance(Location.Distance distance) {
        this.distance = distance;
    }

    public Location.GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(Location.GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public String getDetailedName() {
        return detailedName;
    }

    public void setDetailedName(String detailedName) {
        this.detailedName = detailedName;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
