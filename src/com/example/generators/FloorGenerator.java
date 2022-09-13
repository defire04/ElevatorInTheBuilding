package com.example.generators;

import com.example.models.Floor;
import com.example.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class FloorGenerator {


    public static List<Floor> create() {
        int countOfFloors = Random.randomNumberOf("countOfFloors");
        int numberOfPassengers;
        List<Floor> floorList = new ArrayList<>();

        for (int i = 0; i < countOfFloors; i++) {
            numberOfPassengers = Random.randomNumberOf("numberOfPassengers");
            floorList.add(new Floor(numberOfPassengers, PassengerGenerator.create(countOfFloors, numberOfPassengers, i+1), i + 1));
        }


        return floorList;
    }
}
