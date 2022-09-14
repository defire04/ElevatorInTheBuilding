package com.example.models;

import com.example.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Elevator {
    public static final int MAXIMUM_CAPACITY = 5;
    private Direction direction;
    private int placesLeft;

    private int headingTowards;
    private int currentFloor;

    private final List<Passenger> passengersInElevator = new ArrayList<>();

    private final Set<Integer> floorsWillTheElevatorGoTo = new TreeSet<>();

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

    public List<Passenger> getPassengersInElevator() {
        return passengersInElevator;
    }

    public Set<Integer> getFloorsWillTheElevatorGoTo() {
        return floorsWillTheElevatorGoTo;
    }

    @Override
    public String toString() {
        return "-------------Elevator---------------" +
                "\nCurrentFloor " + this.currentFloor +
                "\nPlacesLeft " + this.placesLeft +
                "\nPassengersInElevator: " + this.passengersInElevator +
                "\nSize: " + this.passengersInElevator.size() +
                "\nHeadingTowards: " + this.floorsWillTheElevatorGoTo +
                "\nDirection: " + this.direction;
    }
}
