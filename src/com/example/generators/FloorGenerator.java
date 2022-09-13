package com.example.generators;

public class FloorGenerator {
   public static int randomNumberOfPassengersOnFloor() {
        double max = 10;
        double min = 0;
        max -= min;
        return (int) ((Math.random() * ++max) + min);
    }
}
