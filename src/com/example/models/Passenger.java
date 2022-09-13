package com.example.models;

public class Passenger {
    private int desiredFloor;
    private int currentFloor;

    public Passenger() {
    }

    public Passenger(int desiredFloor, int currentFloor) {
        this.desiredFloor = desiredFloor;
        this.currentFloor = currentFloor;
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
}
