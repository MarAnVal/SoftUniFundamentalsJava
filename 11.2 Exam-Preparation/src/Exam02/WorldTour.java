package Exam02;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String stops = input.nextLine();
        String commandLine = input.nextLine();
        while (!commandLine.equals("Travel")) {
            String command = commandLine.split(":")[0];
            switch (command) {
                case "Add Stop":
                    //"Add Stop:{index}:{string}":
                    //Insert the given string at that index only if the index is valid
                    //Note: After each command, print the current state of the string if it is valid!
                    int index = Integer.parseInt(commandLine.split(":")[1]);
                    String textToAdd = commandLine.split(":")[2];
                    if (index > -1 && index < stops.length()) {
                        stops = String.format("%s%s%s", stops.substring(0, index), textToAdd, stops.substring(index));

                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    //"Remove Stop:{start_index}:{end_index}":
                    //Remove the elements of the string from the starting index to the end index (inclusive) if both indices are valid
                    //Note: After each command, print the current state of the string if it is valid!

                    int startIndex = Integer.parseInt(commandLine.split(":")[1]);
                    int endIndex = Integer.parseInt(commandLine.split(":")[2]);
                    if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
                        if (startIndex > endIndex) {
                            int buffer = startIndex;
                            startIndex = endIndex;
                            endIndex = buffer;
                        }
                        if (endIndex < stops.length() - 1) {
                            stops = String.format("%s%s", stops.substring(0, startIndex), stops.substring(endIndex + 1));
                        } else {
                            stops = stops.substring(0, startIndex);
                        }


                    }
                    System.out.println(stops);

                    break;
                case "Switch":
                    //"Switch:{old_string}:{new_string}":
                    //If the old string is in the initial string, replace it with the new one (all occurrences)
                    //Note: After each command, print the current state of the string if it is valid!

                    String oldString = commandLine.split(":")[1];
                    String newString = commandLine.split(":")[2];
                    if (stops.contains(oldString)) {
                        stops = stops.replaceAll(oldString, newString);

                    }
                    System.out.println(stops);
                    break;
            }
            commandLine = input.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }
}
