import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        //reads n lines of strings and extracts the name and age of a given person.
        // The person's name will be between "@" and "|".
        // The person's age will be between "#" and "*"
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            int nameStart = line.indexOf('@');
            int nameEnd = line.indexOf("|");
            int ageStart = line.indexOf("#");
            int ageEnd = line.indexOf('*');
            String name = line.substring(nameStart + 1, nameEnd);
            String age = line.substring(ageStart + 1, ageEnd);
            //"{name} is {age} years old."
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
