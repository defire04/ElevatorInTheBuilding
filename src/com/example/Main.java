package com.example;

import com.example.controllers.ElevatorController;
import com.example.generators.FloorGenerator;
import com.example.generators.PassengerGenerator;
import com.example.generators.Random;
import com.example.models.Floor;
import com.example.models.Passenger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Floor> a = FloorGenerator.create();
//
//        a.forEach(System.out::println);
//        System.out.println("=========================");
//        ElevatorController.operation(a);


        List<Floor> b = new ArrayList<>();


        b.add(new Floor(PassengerGenerator.create(4, 1, 1), 1));
        b.add(new Floor(PassengerGenerator.create(4, 1, 2), 2));
        b.add(new Floor(PassengerGenerator.create(4, 1, 3), 3));
        b.add(new Floor(PassengerGenerator.create(4, 1, 4), 4));


        b.forEach(System.out::println);
        System.out.println("=========================");

        ElevatorController.operation(b);


//        System.out.println(a.size());


//        System.out.println(a.get(0));
//        System.out.println("--------------");

//        System.out.println(a.get(0).getPassengers().stream().?);

//        List<Passenger> p = PassengerGenerator.create(20, 5, 5);
//        p.forEach(System.out::println);
    }
}
