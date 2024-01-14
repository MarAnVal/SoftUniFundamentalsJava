package Exam03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        LinkedHashMap<String, Integer> carMileageMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> carFuelMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            //"{car}|{mileage}|{fuel}"
            String line = input.nextLine();
            String car = line.split("\\|")[0];
            Integer mileage = Integer.parseInt(line.split("\\|")[1]);
            Integer fuel = Integer.parseInt(line.split("\\|")[2]);
            if (fuel > 75) {
                fuel = 75;
            }
            carFuelMap.put(car, fuel);
            carMileageMap.put(car, mileage);
        }
        String line = input.nextLine();
        while (!line.equals("Stop")) {
            String command = line.split(" : ")[0];
            switch (command) {
                //"Drive : {car} : {distance} : {fuel}"
                case "Drive":
                    String carDrive = line.split(" : ")[1];
                    Integer distance = Integer.parseInt(line.split(" : ")[2]);
                    Integer fuelDrive = Integer.parseInt(line.split(" : ")[3]);
                    if (fuelDrive > carFuelMap.get(carDrive)) {
                        //You need to drive the given distance, and you will need the given fuel to do that.
                        // If the car doesn't have enough fuel, print: "Not enough fuel to make that ride"
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        //If the car has the required fuel available in the tank, increase its mileage with the given distance,
                        // decrease its fuel with the given fuel,
                        //and print:  "{car} driven for {distance} kilometers. {fuel} liters of fuel consumed."
                        carFuelMap.put(carDrive, carFuelMap.get(carDrive) - fuelDrive);
                        carMileageMap.put(carDrive, carMileageMap.get(carDrive) + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                carDrive, distance, fuelDrive);
                        //You like driving new cars only, so if a car's mileage reaches 100 000 km, remove it from the
                        // collection(s) and print: "Time to sell the {car}!"
                        if (carMileageMap.get(carDrive) >= 100000) {
                            System.out.printf("Time to sell the %s!%n", carDrive);
                            carMileageMap.remove(carDrive);
                            carFuelMap.remove(carDrive);
                        }
                    }
                    break;
                //"Refuel : {car} : {fuel}":
                case "Refuel":
                    String carRefuel = line.split(" : ")[1];
                    int fuelRefuel = Integer.parseInt(line.split(" : ")[2]);
                    carFuelMap.put(carRefuel, carFuelMap.get(carRefuel) + fuelRefuel);
                    if (carFuelMap.get(carRefuel) > 75) {
                        //Refill the tank of your car.
                        //Each tank can hold a maximum of 75 liters of fuel, so if the given amount of fuel is more than
                        // you can fit in the tank, take only what is required to fill it up.
                        fuelRefuel -= (carFuelMap.get(carRefuel) - 75);
                        carFuelMap.put(carRefuel, 75);
                    }
                    //Print a message in the following format: "{car} refueled with {fuel} liters"
                    System.out.printf("%s refueled with %d liters%n", carRefuel, fuelRefuel);
                    break;
                //"Revert : {car} : {kilometers}":
                case "Revert":
                    String carRevert = line.split(" : ")[1];
                    int kilometers = Integer.parseInt(line.split(" : ")[2]);
                    //Decrease the mileage of the given car with the given kilometers and print the kilometers you
                    // have decreased it with in the following format:
                    //"{car} mileage decreased by {amount reverted} kilometers"
                    carMileageMap.put(carRevert, carMileageMap.get(carRevert) - kilometers);

                    //If the mileage becomes less than 10 000km after it is decreased, just set it to 10 000km and
                    //DO NOT print anything.
                    if (carMileageMap.get(carRevert) < 10000) {
                        carMileageMap.put(carRevert, 10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carRevert, kilometers);
                    }
                    break;
            }

            line = input.nextLine();
        }
        //Upon receiving the "Stop" command, you need to print all cars in your possession in the following format:
        //"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."
        for (Map.Entry<String, Integer> entry : carFuelMap.entrySet()) {
            String car = entry.getKey();
            int mileage = carMileageMap.get(car);
            int fuel = entry.getValue();
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileage, fuel);
        }
    }
}
