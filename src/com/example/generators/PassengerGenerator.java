package com.example.generators;

import com.example.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerGenerator {
    public static List<Passenger> create(int maxFloor) {
        List<Passenger> passengers = new ArrayList<>();

        int currentFloor;
        int desiredFloor;
        for (int i = 0; i < Random.randomNumberOf("numberOfPassengers"); i++) {

            currentFloor = Random.desiredAndCurrentFloor(maxFloor);
            desiredFloor = Random.desiredAndCurrentFloor(maxFloor);

            if (currentFloor == 0) {
                passengers.add(new Passenger(desiredFloor, currentFloor,
                        "up"));
            } else if (currentFloor == maxFloor) {
                passengers.add(new Passenger(desiredFloor, currentFloor,
                        "down"));
            } else {
                passengers.add(new Passenger(desiredFloor, currentFloor,
                        Random.upOrDown()));
            }
        }

        return passengers;
    }
}
