package com.example.trip.dto;

public class FlightSearchRequestDTO {

    private String originLocationCode;
    private String destinationLocationCode;
    private String departureDate;
    private String returnDate;
    private int adults;

    public FlightSearchRequestDTO(String originLocationCode, String destinationLocationCode, String departureDate, String returnDate, int adults) {
        this.originLocationCode = originLocationCode;
        this.destinationLocationCode = destinationLocationCode;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.adults = adults;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(String originLocationCode) {
        this.originLocationCode = originLocationCode;
    }

    public String getDestinationLocationCode() {
        return destinationLocationCode;
    }

    public void setDestinationLocationCode(String destinationLocationCode) {
        this.destinationLocationCode = destinationLocationCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }
}
