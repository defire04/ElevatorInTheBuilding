package com.example;

import com.example.controllers.ElevatorController;
import com.example.generators.FloorGenerator;
import com.example.generators.PassengerGenerator;
import com.example.generators.Random;
import com.example.models.Floor;
import com.example.models.Passenger;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Floor> a = FloorGenerator.create();

        a.forEach(System.out::println);
        System.out.println("=========================");
        ElevatorController.operation(a);




//        System.out.println(a.size());


//        System.out.println(a.get(0));
//        System.out.println("--------------");

//        System.out.println(a.get(0).getPassengers().stream().?);

//        List<Passenger> p = PassengerGenerator.create(20, 5, 5);
//        p.forEach(System.out::println);
    }
}
