import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    static class Vehicle {
       //{typeOfVehicle} {model} {color} {horsepower}
        private String typeOfVehicle;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String typeOfVehicle, String model, String color, int horsepower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getModel() {
            return this.model;
        }

        @Override
        public String toString() {
            //Type: {typeOfVehicle}
            //Model: {modelOfVehicle}
            //Color: {colorOfVehicle}
            //Horsepower: {horsepowerOfVehicle}
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                    this.typeOfVehicle, this.model, this.color, this.horsepower);
        }
    }

    public static void main(String[] args) {
        //{typeOfVehicle} {model} {color} {horsepower}
        Scanner input = new Scanner(System.in);
        List<Vehicle> vehicleList = new ArrayList<>();
        //Until you receive the command "End" you will receive lines of input in the format:
        String command = input.nextLine();
        int carCount = 0;
        int truckCount = 0;
        double carHorsepower = 0.0;
        double truckHorsepower = 0.0;
        while (!command.equals("End")){
            //{typeOfVehicle} {model} {color} {horsepower}
            if (command.split(" ")[0].equals("car")){
                Vehicle currentVehicle = new Vehicle("Car", command.split(" ")[1],
                        command.split(" ")[2], Integer.parseInt(command.split(" ")[3]));
                carCount++;
                carHorsepower += Double.parseDouble(command.split(" ")[3]);
                vehicleList.add(currentVehicle);
            } else if (command.split(" ")[0].equals("truck")){
                Vehicle currentVehicle = new Vehicle("Truck", command.split(" ")[1],
                        command.split(" ")[2], Integer.parseInt(command.split(" ")[3]));
                truckCount++;
                truckHorsepower += Double.parseDouble(command.split(" ")[3]);
                vehicleList.add(currentVehicle);
            }

            command = input.nextLine();
        }
        command = input.nextLine();
        while (!command.equals("Close the Catalogue")){
            for (Vehicle element: vehicleList) {
                if (element.getModel().equals(command)){
                    System.out.println(element);
                }
            }
            command = input.nextLine();
        }
        double totalCarHorsepower, totalTruckHorsepower;
        if (carCount == 0){
            totalCarHorsepower = 0.0;
        } else {
            totalCarHorsepower = carHorsepower/ carCount;
        }
        if (truckCount == 0){
            totalTruckHorsepower = 0.0;
        } else {
            totalTruckHorsepower = truckHorsepower/ truckCount;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", totalCarHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", totalTruckHorsepower);

    }
}
