package Exam01;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String line = input.nextLine();
        while (!line.equals("Decode")) {
            String command = line.split("\\|")[0];
            switch (command) {
                //"Move|{number of letters}":
                //Moves the first n letters to the back of the string
                case "Move":
                    int numberLetters = Integer.parseInt(line.split("\\|")[1]);
                    if (numberLetters > 0 && numberLetters < text.length()) {
                        String firstNLetters = text.substring(0, numberLetters);
                        String lastLetters = text.substring(numberLetters);
                        text = String.format("%s%s", lastLetters, firstNLetters);
                    }
                    break;
                //"Insert|{index}|{value}":
                //Inserts the given value before the given index in the string
                case "Insert":
                    int index = Integer.parseInt(line.split("\\|")[1]);
                    if (index > text.length()){
                        index = text.length();
                    } else if (index < 0){
                        index = 0;
                    }
                    String element = "";
                    if (line.split("\\|").length == 3){
                        element = line.split("\\|")[2];
                        String beforeIndex = text.substring(0, index);
                        String afterIndex = text.substring(index);
                        text = String.format("%s%s%s", beforeIndex, element, afterIndex);

                    }
                    break;
                //"ChangeAll|{substring}|{replacement}":
                //Changes all occurrences of the given substring with the replacement text
                case "ChangeAll":
                    String change = line.split("\\|")[1];
                    String replaced = "";
                    if(line.split("\\|").length == 3) {
                        replaced = line.split("\\|")[2];
                    }
                    for (int i = 0; i < change.length(); i++) {
                        if(!Character.isDigit(change.charAt(i))&&!Character.isLetter(change.charAt(i))){
                            change = String.format("%s\\%s", change.substring(0, i), change.substring(i));
                            i++;
                        }
                    }
                    for (int i = 0; i < replaced.length(); i++) {
                        if(!Character.isDigit(replaced.charAt(i))&&!Character.isLetter(replaced.charAt(i))){
                            replaced = String.format("%s\\%s", replaced.substring(0, i), replaced.substring(i));
                            i++;
                        }
                    }
                    text = text.replaceAll(change, replaced);
                    break;
            }
            line = input.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", text);
    }
}
