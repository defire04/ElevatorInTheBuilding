package com.example.controllers;

import com.example.enums.Direction;
import com.example.generators.PassengerGenerator;
import com.example.models.Elevator;
import com.example.models.Floor;
import com.example.models.Passenger;
import com.example.view.PrintElevatorInfo;

import java.util.*;
import java.util.stream.Collectors;

public class ElevatorController {
    public static void operation(List<Floor> building) {

        Elevator elevator = new Elevator(1);


        while (true) {

            Floor currentFloor;

            if (elevator.getCurrentFloor() == 0) {
                currentFloor = building.get(1);
            } else {
                currentFloor = building.get(elevator.getCurrentFloor() - 1);
            }

//            System.out.println("------------================================= Step " + (step) + "=================================------------ ");
//            System.out.println(currentFloor);
//            System.out.println(elevator);
            PrintElevatorInfo.print(building, elevator);

            if (elevator.getDirection() == Direction.WAITING) {

                if (!elevator.getPassengersInElevator().isEmpty()) {
                    findDirection(elevator);
                } else if (!currentFloor.getPassengers().isEmpty()) {
                    findDirection(currentFloor, elevator);
                } else {
                    if (building.stream().anyMatch(floor -> !(floor.getPassengers().isEmpty()))) {
                        elevator.setCurrentFloor(building.stream().filter(floor -> !(floor.getPassengers().isEmpty())).toList().get(0).getNumber());
                    } else {
                        return;
                    }
                }
            }


            if (currentFloor.getPassengers().isEmpty() && elevator.getPassengersInElevator()
                    .stream().noneMatch(p -> p.getDesiredFloor() == currentFloor.getNumber())) {
                goInTheDirection(elevator);

                continue;
            }

            if (elevator.getPassengersInElevator().stream().anyMatch(p -> p.getDesiredFloor() == currentFloor.getNumber())) {
                unloadingPassengerFromTheElevator(currentFloor, elevator, building.size() - 1);

            }

            if (elevator.getPassengersInElevator().isEmpty() && currentFloor.getPassengers().stream().noneMatch(p -> p.getDirection() == elevator.getDirection())) {
                findDirection(currentFloor, elevator);
            }

            if (currentFloor.getPassengers().stream().anyMatch(p -> p.getDirection() == elevator.getDirection() && elevator.getPlacesLeft() > 0)) {
                pickUpPeopleFromFloor(currentFloor, elevator);
            }


            goInTheDirection(elevator);

        }
    }

    private static void unloadingPassengerFromTheElevator(Floor currentFloor, Elevator elevator, int maxFloor) {

        List<Passenger> removeList = new ArrayList<>();

        for (Passenger passenger : elevator.getPassengersInElevator()) {
            if (passenger.getDesiredFloor() == currentFloor.getNumber()) {
                removeList.add(passenger);

// для выполнения условия задание что людям которые прибыли на этаж переопределить желаемый этаж
//                PassengerGenerator.overrideDesiredFloor(passenger, currentFloor.getNumber(), maxFloor);
//                currentFloor.getPassengers().add(passenger);

            }
        }

        System.out.println("These people left the elevator: " + removeList);

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

    private static void findDirection(Elevator elevator) {
        Direction direction = elevator.getPassengersInElevator().get(0).getDirection();
        elevator.setDirection(direction);
    }

    private static void findDirection(Floor currentFloor, Elevator elevator) {// выбор направления по этажу

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
        } else if (currentFloor.getNumber() == 0) {
            elevator.setDirection(Direction.UP);
        } else {
            elevator.setDirection(Direction.WAITING);
        }
    }
}
