package com.example.models;

public class Elevator {
    public static final int MAXIMUM_CAPACITY = 5;
    private String direction;
    private int placesLeft;

    private int floorThatTheElevatorGoesTo;

    public Elevator() {
    }

    public Elevator(String direction, int placesLeft) {
        this.direction = direction;
        this.placesLeft = placesLeft;
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

    public int getFloorThatTheElevatorGoesTo() {
        return floorThatTheElevatorGoesTo;
    }

    public void setFloorThatTheElevatorGoesTo(int floorThatTheElevatorGoesTo) {
        this.floorThatTheElevatorGoesTo = floorThatTheElevatorGoesTo;
    }
}
