package com.example.models;

import com.example.enums.Direction;



public class Passenger {
    private int desiredFloor;
    private int currentFloor;

    private Direction direction;

    public Passenger() {
    }

    public Passenger(int desiredFloor, int currentFloor, Direction direction) {
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Passenger(Desired Floor = " + this.getDesiredFloor() + " Direction:" + this.direction + ")" + this.currentFloor;

    }
}
