package com.example.airline_api.models;

import java.awt.*;
import java.util.List;

public class PassengerDTO {

    private String name;
    private int phoneNumber;
    private List<Long> flightIds;

    public PassengerDTO(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flightIds = flightIds;
    }

    public PassengerDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Long> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(List<Long> flightIds) {
        this.flightIds = flightIds;
    }
}
