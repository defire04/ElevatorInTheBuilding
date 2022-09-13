package com.example.models;

public class Passenger {
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

    @Override
    public String toString() {
        return "Passenger{" +
                "desiredFloor=" + desiredFloor +
                ", currentFloor=" + currentFloor +
                ", direction='" + direction + '\'' +
                '}';
    }
}
