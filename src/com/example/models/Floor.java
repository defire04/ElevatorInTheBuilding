package com.example.models;

import java.util.List;

public class Floor {
    private int numberOfPassengers;

    private List<Passenger> passengers;

    private int number;

    public Floor() {
    }

    public Floor(int numberOfPassengers, List<Passenger> passengers, int number) {
        this.numberOfPassengers = numberOfPassengers;
        this.passengers = passengers;
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Floor №" + this.number +
                "\nNumber of passengers = " + this.numberOfPassengers +
                "\nPassengers:" + this.passengers +
                "\nSizeArrList = " + this.passengers.size();
    }
}
