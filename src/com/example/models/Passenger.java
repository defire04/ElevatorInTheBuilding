package com.example.models;

import com.example.enums.Direction;

import java.util.Comparator;

public class Passenger implements Comparator<Passenger> {
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
        return "Passenger{" +
                "desiredFloor=" + desiredFloor +
                ", currentFloor=" + currentFloor +
                ", direction='" + direction + '\'' +
                '}';
    }

    @Override
    public int compare(Passenger o1, Passenger o2) {
        return  o1.desiredFloor -  o2.desiredFloor;
    }
}
