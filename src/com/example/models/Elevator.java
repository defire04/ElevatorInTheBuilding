package com.example.models;

import com.example.enums.Direction;

import java.util.ArrayList;
import java.util.List;


public class Elevator {
    public static final int MAXIMUM_CAPACITY = 5;
    private Direction direction;
    private int placesLeft;

    private int currentFloor;

    private final List<Passenger> passengersInElevator = new ArrayList<>();


    public Elevator() {
    }

    public Elevator(Direction direction, int currentFloor) {
        this.direction = direction;
        this.currentFloor = currentFloor;
        this.placesLeft = MAXIMUM_CAPACITY;
    }

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        this.direction = Direction.WAITING;
        this.placesLeft = MAXIMUM_CAPACITY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getPlacesLeft() {
        return placesLeft;
    }

    public void setPlacesLeft(int placesLeft) {
        this.placesLeft = placesLeft;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public List<Passenger> getPassengersInElevator() {
        return passengersInElevator;
    }



    @Override
    public String toString() {
        return "-------------Elevator---------------" +
                "\nCurrentFloor " + this.currentFloor +
                "\nPlacesLeft " + this.placesLeft +
                "\nPassengersInElevator: " + this.passengersInElevator +
                "\nDirection: " + this.direction;
    }
}
