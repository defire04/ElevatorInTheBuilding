package com.example.view;

import com.example.models.Elevator;
import com.example.models.Floor;

import java.util.List;

public class PrintElevatorInfo {
    public static void print(List<Floor> buildingNow, Elevator elevator){
        System.out.println("===============================================");
        for (int i =  buildingNow.size() -1 ; i >= 0 ; i--) {

            Floor floor = buildingNow.get(i);

            if (elevator.getCurrentFloor() != floor.getNumber()) {
                System.out.println("                " + floor.getNumber() + ": Passengers: " + floor.getPassengers());
            } else {
                System.out.println("*               " + floor.getNumber() + ": Passengers: " + floor.getPassengers());
            }
        }
    }

}
