package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    public static final int MAXIMUM_CAPACITY = 5;
    private String direction;
    private int placesLeft;

    private int headingTowards;
    private int currentFloor;

    private int nearestStop;

    private final List<Passenger> passengersInElevator = new ArrayList<>();

    public Elevator() {
    }

    public Elevator(String direction, int currentFloor) {
        this.direction = direction;
        this.currentFloor = currentFloor;
        this.placesLeft = MAXIMUM_CAPACITY;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getPlacesLeft() {
        return placesLeft;
    }

    public void setPlacesLeft(int placesLeft) {
        this.placesLeft = placesLeft;
    }

    public int getHeadingTowards() {
        return headingTowards;
    }

    public void setHeadingTowards(int headingTowards) {
        this.headingTowards = headingTowards;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getNearestStop() {
        return nearestStop;
    }

    public void setNearestStop(int nearestStop) {
        this.nearestStop = nearestStop;
    }

    public List<Passenger> getPassengersInElevator() {
        return passengersInElevator;
    }
}
