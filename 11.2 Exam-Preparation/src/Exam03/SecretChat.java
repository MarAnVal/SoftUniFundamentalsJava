package Exam03;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String massage = input.nextLine();
        String line = input.nextLine();
        while (!line.equals("Reveal")) {
            String command = line.split(":\\|:")[0];
            switch (command) {
                //"InsertSpace:|:{index}":
                //Inserts a single space at the given index. The given index will always be valid.
                case "InsertSpace":
                    int indexInsert = Integer.parseInt(line.split(":\\|:")[1]);
                    massage = String.format("%s %s", massage.substring(0, indexInsert), massage.substring(indexInsert));
                    System.out.println(massage);
                    break;
                //"Reverse:|:{substring}":
                //If the message contains the given substring, cut it out, reverse it and add it at the end of the message.
                //If not, print "error".
                case "Reverse":
                    String textReverse = line.split(":\\|:")[1];
                    if(massage.contains(textReverse)){
                        int start = massage.indexOf(textReverse);
                        int end = textReverse.length() + start;
                        massage = String.format("%s%s", massage.substring(0,start), massage.substring(end));
                        String reversed = "";
                        for (int i = textReverse.length() -1; i >= 0 ; i--) {
                            reversed = String.format("%s%c", reversed, textReverse.charAt(i));
                        }
                        massage = String.format("%s%s", massage, reversed);
                        System.out.println(massage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                //This operation should replace only the first occurrence of the given substring if there are two or more occurrences.
                //"ChangeAll:|:{substring}:|:{replacement}":
                //Changes all occurrences of the given substring with the replacement text.
                case "ChangeAll":
                    String textChange = line.split(":\\|:")[1];
                    String replacement = line.split(":\\|:")[2];
                    while(massage.contains(textChange)){
                        int start = massage.indexOf(textChange);
                        int end = start + textChange.length();
                        massage = String.format("%s%s%s", massage.substring(0, start), replacement, massage.substring(end));
                    }
                    System.out.println(massage);
            }

            line = input.nextLine();
        }
        System.out.printf("You have a new text message: %s%n",massage);
    }
}
