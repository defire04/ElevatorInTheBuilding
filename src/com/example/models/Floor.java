package com.example.models;

import java.util.List;

public class Floor {
    private int numberOfPassengers;

    private List<Passenger> passengers;

    public Floor() {
    }

    public Floor(int numberOfPassengers, List<Passenger> passengers) {
        this.numberOfPassengers = numberOfPassengers;
        this.passengers = passengers;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
