package com.example;

import com.example.generators.FloorGenerator;
import com.example.generators.PassengerGenerator;
import com.example.generators.Random;
import com.example.models.Floor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Floor> a = FloorGenerator.create();
        a.forEach(System.out::println);
        System.out.println(a.size());
    }
}
