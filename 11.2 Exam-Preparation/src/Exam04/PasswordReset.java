package Exam04;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        String line = input.nextLine();

        while (!line.equals("Done")) {
            String command = line.split("\\s+")[0];
            switch (command) {
                //"TakeOdd"
                case "TakeOdd":
                    // Takes only the characters at odd indices and concatenates them to
                    // obtain the new raw password and then prints it.
                    String rawPassword = "";
                    for (int i = 1; i < password.length(); i += 2) {
                        rawPassword = String.format("%s%c", rawPassword, password.charAt(i));

                    }
                    password = rawPassword;
                    System.out.println(password);
                    break;
                //"Cut {index} {length}"
                case "Cut":
                    int indexCut = Integer.parseInt(line.split("\\s+")[1]);
                    int length = Integer.parseInt(line.split("\\s+")[2]);
                    //Gets the substring with the given length starting from the given index from the password
                    // and removes its first occurrence, then prints the password on the console.
                    int indexCutEnd = indexCut + length;
                    if (indexCutEnd < password.length()){
                    password = String.format("%s%s", password.substring(0,indexCut), password.substring(indexCutEnd));
                    } else {
                        password = password.substring(0,indexCut);
                    }
                    System.out.println(password);
                    //The given index and the length will always be valid.
                    break;
                    //"Substitute {substring} {substitute}"
                case "Substitute":
                    String substring = line.split("\\s+")[1];
                    String substitute = line.split("\\s+")[2];
                    //If the raw password contains the given substring, replaces all of its occurrences with
                    // the substitute text given and prints the result.
                    if (password.contains(substring)){
                        while (password.contains(substring)) {
                            int indexStart = password.indexOf(substring);
                            int indexEnd = indexStart + substring.length();
                            password = String.format("%s%s%s", password.substring(0, indexStart), substitute
                                    , password.substring(indexEnd));
                        }
                        System.out.println(password);
                    } else {
                        //If it doesn't, prints "Nothing to replace!".
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            line = input.nextLine();
        }
        //After the "Done" command is received, print:
        //"Your password is: {password}"
        System.out.printf("Your password is: %s", password);
    }
}
