package com.example.generators;

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
                        "up"));
            } else if (currentFloor == maxFloor) {
                passengers.add(new Passenger(desiredFloor, currentFloor,
                        "down"));
            } else {
                if (currentFloor - desiredFloor > 0) {
                    passengers.add(new Passenger(desiredFloor, currentFloor, "down"));
                } else {
                    passengers.add(new Passenger(desiredFloor, currentFloor, "up"));
                }
            }
        }

        return passengers;
    }
}
