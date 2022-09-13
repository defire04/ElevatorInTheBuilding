package com.example.generators;

public class Random {
    public static int randomNumberOf(String mode) {
        double max;
        double min;
        if (mode.equals("numberOfPassengers")) {
            max = 10;
            min = 0;
        } else if (mode.equals("countOfFloors")) {
            max = 20;
            min = 5;

        } else{
            max = 1;
            min = 0;
        }

        max -= min;
        return (int) ((Math.random() * ++max) + min);
    }

    public static int desiredAndCurrentFloor(int maxFloor){
        int min = 0;
        return (int) ((Math.random() * ++maxFloor) + min);
    }

    public static String upOrDown(){
        String [] upAndDownArr = {"up", "down"};
        return upAndDownArr[(int) ((Math.random() * 2) + 0)];
    }
}
