package com.example.generators;

import com.example.enums.Direction;
import com.example.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerGenerator {
    public static List<Passenger> create(int maxFloor, int numberOfPassengers, int currentFloor) {
        List<Passenger> passengers = new ArrayList<>();

        int desiredFloor;
        for (int i = 0; i < numberOfPassengers; i++) {

            do {
                desiredFloor = Random.desiredAndCurrentFloor(maxFloor);
            }
            while (currentFloor == desiredFloor);

            if (currentFloor == 1) {
                passengers.add(new Passenger(desiredFloor, currentFloor,
                        Direction.UP));
            } else if (currentFloor == maxFloor) {
                passengers.add(new Passenger(desiredFloor, currentFloor,
                        Direction.DOWN));
            } else {
                if (currentFloor - desiredFloor > 0) {
                    passengers.add(new Passenger(desiredFloor, currentFloor, Direction.DOWN));
                } else {
                    passengers.add(new Passenger(desiredFloor, currentFloor, Direction.UP));
                }
            }
        }

        return passengers;
    }


    public static void overrideDesiredFloor(Passenger passenger, int currentFloor, int maxFloor) {
        passenger.setCurrentFloor(currentFloor);
        int desiredFloor = Random.desiredAndCurrentFloor(maxFloor);


        while (desiredFloor == currentFloor) {
            desiredFloor = Random.desiredAndCurrentFloor(maxFloor);
        }



        passenger.setDesiredFloor(desiredFloor);
        if (currentFloor == 1) {
            passenger.setDirection(Direction.UP);
        } else if (currentFloor == maxFloor) {
            passenger.setDirection(Direction.DOWN);
        } else {
            if (currentFloor - desiredFloor > 0) {
                passenger.setDirection(Direction.DOWN);
            } else {
                passenger.setDirection(Direction.UP);
            }
        }
    }

}
