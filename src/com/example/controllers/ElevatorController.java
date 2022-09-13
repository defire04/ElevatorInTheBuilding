package com.example.controllers;

import com.example.models.Elevator;
import com.example.models.Floor;
import com.example.models.Passenger;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ElevatorController {
    public static void operation(List<Floor> a) {
        List<Floor> building = a;

//        Elevator elevator = new Elevator("up", 1);
//        elevator.setDirection("up");
//        findHeadingTowards(a, elevator);
//        System.out.println(elevator.getHeadingTowards());
//
//        elevator.setDirection("down");
//        findHeadingTowards(a, elevator);
//        System.out.println(elevator.getHeadingTowards());

        Elevator elevator = new Elevator("up", 1);

        findHeadingTowards(a, elevator);
        System.out.println(elevator.getHeadingTowards());

        int tempPlacesLeft;
        Floor currentFloor;

        while (true) {
            currentFloor = building.get(elevator.getCurrentFloor());


            if (elevator.getDirection().equals("up")) {
                if (currentFloor.getPassengers().isEmpty()) {
                    elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                    continue;
                }
            } else if (elevator.getDirection().equals("down")) {
                if (currentFloor.getPassengers().isEmpty()) {
                    elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                    continue;
                }
            }


            // ----------------------------------- Загрузка людей в лифт --------------------------
            findWhereDoesElevatorLead(currentFloor, elevator);                                   // Ищем куда идет лифт

            List<Passenger> passengersOnFloorWhoAreTravelingInDirectionOfTheElevator = currentFloor.getPassengers().stream().filter(p -> p.getDirection()
                    .equals(elevator.getDirection())).toList();                                  //пассажиры на этаже которые едут в направление лифта


            for (int i = 0; i < passengersOnFloorWhoAreTravelingInDirectionOfTheElevator.size(); i++) {
                if (elevator.getPlacesLeft() != 0) {                                               // ищем сколько мест останется
                    elevator.getPassengersInElevator().add(currentFloor.getPassengers().get(i)); // в лифт сел
                    currentFloor.getPassengers().remove(currentFloor.getPassengers().get(i));    // из этажа удалали человека
                    elevator.setPlacesLeft(Elevator.MAXIMUM_CAPACITY - 1);
                } else {
                    continue;
                }
            }


        }
    }

    private static void findWhereDoesElevatorLead(Floor floor, Elevator elevator) {
        List<Passenger> passengers = floor.getPassengers();


        int headingTowardsForTop = Integer.MIN_VALUE;
        int headingTowardsForBottom = Integer.MAX_VALUE;

        int tempGetDesiredFloor;
        elevator.setHeadingTowards(0);

        if (!passengers.isEmpty()) {
            for (Passenger passenger : passengers) {
                tempGetDesiredFloor = passenger.getDesiredFloor();

                if (elevator.getDirection().equals("up") && passenger.getDirection().equals("up")) {
                    if (headingTowardsForTop < tempGetDesiredFloor) {
                        headingTowardsForTop = tempGetDesiredFloor;
                        elevator.setHeadingTowards(headingTowardsForTop);
                    }
                } else if (elevator.getDirection().equals("down") && passenger.getDirection().equals("down")) {
                    if (headingTowardsForBottom > tempGetDesiredFloor) {
                        headingTowardsForBottom = tempGetDesiredFloor;
                        elevator.setHeadingTowards(headingTowardsForBottom);
                    }
                }
            }

        }
    }

    private static void findHeadingTowards(List<Floor> building, Elevator elevator) {

        System.out.println(elevator.getDirection());
        int headingTowardsForTop = Integer.MIN_VALUE;
        int headingTowardsForBottom = Integer.MAX_VALUE;

        int tempGetDesiredFloor;
        elevator.setHeadingTowards(0);

        for (Floor floor : building) {
            for (Passenger passenger : floor.getPassengers()) {
                tempGetDesiredFloor = passenger.getDesiredFloor();

                if (elevator.getDirection().equals("up") && passenger.getDirection().equals("up")) {
                    if (headingTowardsForTop < tempGetDesiredFloor) {
                        headingTowardsForTop = tempGetDesiredFloor;
                        elevator.setHeadingTowards(headingTowardsForTop);
                    }
                } else if (elevator.getDirection().equals("down") && passenger.getDirection().equals("down")) {
                    if (headingTowardsForBottom > tempGetDesiredFloor) {
                        headingTowardsForBottom = tempGetDesiredFloor;
                        elevator.setHeadingTowards(headingTowardsForBottom);
                    }
                }
            }
        }
    }
}
