package com.example.controllers;

import com.example.enums.Direction;
import com.example.models.Elevator;
import com.example.models.Floor;
import com.example.models.Passenger;

import java.util.*;
import java.util.stream.Collectors;

public class ElevatorController {
    public static void operation(List<Floor> a) {
        List<Floor> building = a;


        Elevator elevator = new Elevator(1);

        int ttttttt = 0;
        while (ttttttt < 10) {
            ttttttt++;

            Floor currentFloor = a.get(elevator.getCurrentFloor() - 1);


            System.out.println("------------================================= Step " + (ttttttt) + "=================================------------ ");
            System.out.println(currentFloor);
            System.out.println(elevator);

            if (elevator.getDirection() == Direction.WAITING) {
                findDirection(currentFloor, elevator);              // узнали направление
            }

            if (currentFloor.getPassengers().isEmpty() && elevator.getPassengersInElevator()
                    .stream().noneMatch(p -> p.getDesiredFloor() == currentFloor.getNumber())) {
                goInTheDirection(elevator);

                continue;
            }

            if (elevator.getPassengersInElevator().stream().anyMatch(p -> p.getDesiredFloor() == currentFloor.getNumber())) {
                System.out.println("unloadingPassengerFromTheElevator++++++++++++++++++++++++++++++++");
                unloadingPassengerFromTheElevator(currentFloor, elevator);
            }

            if(elevator.getPassengersInElevator().isEmpty() && currentFloor.getPassengers().stream().noneMatch(p-> p.getDirection() == elevator.getDirection())){
                findDirection(currentFloor, elevator);
            }

            if (currentFloor.getPassengers().stream().anyMatch(p -> p.getDirection() == elevator.getDirection() && elevator.getPlacesLeft() > 0)) {
                pickUpPeopleFromFloor(currentFloor, elevator);
            }




            goInTheDirection(elevator);
        }


    }

    private static void unloadingPassengerFromTheElevator(Floor currentFloor, Elevator elevator) {

        List<Passenger> removeList = new ArrayList<>();

        for (Passenger passenger : elevator.getPassengersInElevator()) {
            if (passenger.getDesiredFloor() == currentFloor.getNumber()) {
                removeList.add(passenger);
            }
        }

        System.out.println(removeList);

        elevator.setPlacesLeft(elevator.getPlacesLeft() + removeList.size());

        removeList.forEach(passenger -> {
            elevator.getPassengersInElevator().remove(passenger);
        });


    }

    private static void goInTheDirection(Elevator elevator) {
        if (elevator.getDirection() == Direction.UP) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        } else if (elevator.getDirection() == Direction.DOWN) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
        }
    }

    // загружаем людей
    private static void pickUpPeopleFromFloor(Floor currentFloor, Elevator elevator) {

        for (Passenger passenger : currentFloor.getPassengers()) {
            if (elevator.getDirection() == passenger.getDirection()) {
                if (elevator.getPassengersInElevator().size() < Elevator.MAXIMUM_CAPACITY) {
                    elevator.getPassengersInElevator().add(passenger);
                }
            }
        }

        elevator.getPassengersInElevator().forEach(passenger -> {
            currentFloor.getPassengers().remove(passenger);
        });

        currentFloor.setNumberOfPassengers(currentFloor.getPassengers().size());

        elevator.setPlacesLeft(Elevator.MAXIMUM_CAPACITY - elevator.getPassengersInElevator().size());
    }

    private static void findDirection(Floor currentFloor, Elevator elevator) {

        Map<Direction, Long> hashMap = currentFloor.getPassengers()
                .stream()
                .collect(Collectors
                        .groupingBy(Passenger::getDirection, Collectors.counting()));

        Set<Direction> set = hashMap.keySet();
        if (set.size() == 1) {
            for (Direction direction : set) {
                elevator.setDirection(direction);
            }
        } else if (set.size() == 2) {
            if (hashMap.get(Direction.UP) >= hashMap.get(Direction.DOWN)) {
                elevator.setDirection(Direction.UP);
            } else {
                elevator.setDirection(Direction.DOWN);
            }
        } else if(currentFloor.getNumber() == 0) {
            elevator.setDirection(Direction.UP);
        } else {
            elevator.setDirection(Direction.WAITING);
        }
    }
}
