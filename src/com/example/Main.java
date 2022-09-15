package com.example;

import com.example.controllers.ElevatorController;
import com.example.generators.FloorGenerator;
import com.example.generators.PassengerGenerator;

import com.example.models.Floor;


import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Floor> building = FloorGenerator.create();

        building.forEach(System.out::println);
        System.out.println("=========================");
        ElevatorController.operation(building);




//        ========================FOR TESTING====================================
//        List<Floor> b = new ArrayList<>();
//
//
//        b.add(new Floor(PassengerGenerator.create(4, 1, 1), 1));
//        b.add(new Floor(PassengerGenerator.create(4, 1, 2), 2));
//        b.add(new Floor(PassengerGenerator.create(4, 1, 3), 3));
//        b.add(new Floor(PassengerGenerator.create(4, 1, 4), 4));
//
//
//        b.forEach(System.out::println);
//        System.out.println("=========================");
//
//        ElevatorController.operation(b);
//        ========================FOR TESTING====================================


    }
}
