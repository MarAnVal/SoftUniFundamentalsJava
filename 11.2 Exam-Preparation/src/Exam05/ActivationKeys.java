package Exam05;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        //The first line of the input will be your raw activation key. It will consist of letters and numbers only.
        String line = input.nextLine();
        while (!line.equals("Generate")) {
            String command = line.split(">>>")[0];
            switch (command) {
                //"Contains>>>{substring}":
                case "Contains":
                    String text = line.split(">>>")[1];
                    if (password.contains(text)) {
                        //If the raw activation key contains the given substring,
                        // prints: "{raw activation key} contains {substring}".
                        System.out.printf("%s contains %s%n", password, text);
                    } else {
                        //Otherwise, prints: "Substring not found!"
                        System.out.println("Substring not found!");
                    }
                    break;
                //"Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}":
                case "Flip":
                    String type = line.split(">>>")[1];
                    //All given indexes will be valid.
                    int startIndexFlip = Integer.parseInt(line.split(">>>")[2]);
                    int endIndexFlip = Integer.parseInt(line.split(">>>")[3]);
                    String startFlip = password.substring(0, startIndexFlip);
                    String changeFlip = password.substring(startIndexFlip, endIndexFlip);
                    String endFlip = password.substring(endIndexFlip);
                    switch (type) {
                        //Changes the substring between the given indices (the end index is exclusive) to upper or
                        // lower case and then prints the activation key.
                        case "Upper":
                            changeFlip = changeFlip.toUpperCase(Locale.ROOT);
                            break;
                        case "Lower":
                            changeFlip = changeFlip.toLowerCase(Locale.ROOT);
                            break;
                    }
                    password = String.format("%s%s%s", startFlip, changeFlip, endFlip);
                    System.out.println(password);
                    break;
                    //"Slice>>>{startIndex}>>>{endIndex}":
                case "Slice":
                    //Both indices will be valid.
                    int startIndexSlice = Integer.parseInt(line.split(">>>")[1]);
                    int endIndexSlice = Integer.parseInt(line.split(">>>")[2]);
                    //Deletes the characters between the start and end indices (the end index is exclusive)
                    password = String.format("%s%s", password.substring(0,startIndexSlice), password.substring(endIndexSlice));
                    // and prints the activation key.
                    System.out.println(password);
                    break;
            }
            line = input.nextLine();
        }
        //After the "Generate" command is received, print:
        //"Your activation key is: {activation key}"
        System.out.printf("Your activation key is: %s", password);
    }
}
