package com.example.models;

import java.util.Comparator;

public class Passenger implements Comparator {
    private int desiredFloor;
    private int currentFloor;

    private String direction;

    public Passenger() {
    }

    public Passenger(int desiredFloor, int currentFloor, String direction) {
        this.desiredFloor = desiredFloor;
        this.currentFloor = currentFloor;
        this.direction = direction;
    }

    public Passenger(int desiredFloor) {
        this.desiredFloor = desiredFloor;
    }

    public int getDesiredFloor() {
        return desiredFloor;
    }

    public void setDesiredFloor(int desiredFloor) {
        this.desiredFloor = desiredFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "desiredFloor=" + desiredFloor +
                ", currentFloor=" + currentFloor +
                ", direction='" + direction + '\'' +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        return ((Passenger) o1).desiredFloor - ((Passenger) o2).desiredFloor;
    }
}
