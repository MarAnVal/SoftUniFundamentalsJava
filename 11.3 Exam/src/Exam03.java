import java.util.Locale;
import java.util.Scanner;

public class Exam03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String line = input.nextLine();
        while (!line.equals("End")) {
            String command = line.split("\\s+")[0];
            switch (command) {
                //Translate {char} {replacement}
                case "Translate":
                    //replace all occurrences of the char with the replacement and print the text
                    char givenChar = line.split("\\s+")[1].charAt(0);
                    String replacement = line.split("\\s+")[2];
                    String bufferText = "";
                    for (int i = 0; i < text.length(); i++) {
                       if(text.charAt(i) != givenChar){
                           bufferText = String.format("%s%c", bufferText, text.charAt(i));
                       } else {
                           bufferText = String.format("%s%s", bufferText, replacement);
                       }
                    }
                    text = bufferText;
                    System.out.println(text);
                    break;
                //Includes {substring}
                case "Includes":
                    //check do the text includes the substring and print "True" if yes and "False" if not
                    String textInclude = line.split("\\s+")[1];
                    if (text.contains(textInclude)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }

                    break;
                //Start {substring}
                case "Start":
                    //check do the text start with the substring and print "True" if yes and "False" if not
                    String textStart = line.split("\\s+")[1];
                    if(text.startsWith(textStart)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                //Lowercase
                case "Lowercase":
                    //turn the text in lowercase and print it
                    text = text.toLowerCase(Locale.ROOT);
                    System.out.println(text);
                    break;
                //FindIndex {char}
                case "FindIndex":
                    //find the index ot the last occurrence ot the char and print the index number
                    char charIndex = line.split("\\s+")[1].charAt(0);
                    int lastIndex = text.lastIndexOf(charIndex);
                    System.out.println(lastIndex);
                    break;
                //Remove {startIndex} {count}
                case "Remove":
                    //remove the given count starting from the startIndex and print the text
                    int startIndex = Integer.parseInt(line.split("\\s+")[1]);
                    int count = Integer.parseInt(line.split("\\s+")[2]);
                    int endIndex = startIndex + count;
                    if(endIndex >= text.length()){
                        text = text.substring(0,startIndex);
                    } else {
                        text = String.format("%s%s",text.substring(0,startIndex), text.substring(endIndex));
                    }
                    System.out.println(text);
                    break;
            }
            line = input.nextLine();
        }
    }
}
