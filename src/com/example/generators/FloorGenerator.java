package com.example.generators;

import com.example.models.Floor;
import com.example.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class FloorGenerator {


    public static List<Floor> create() {
        int countOfFloors = Random.randomNumberOf("countOfFloors");
        List<Floor> floorList = new ArrayList<>();

        System.out.println(countOfFloors);
        for (int i = 0; i < countOfFloors; i++) {

            floorList.add(new Floor(Random.randomNumberOf("numberOfPassengers"), PassengerGenerator.create(countOfFloors), i + 1));
        }


        return floorList;
    }
}
