import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        //Write a program to read an integer n and print all triples of the first n small Latin letters, ordered alphabetically:
        for (int i = 97; i < 97 + n; i++){
            for (int j = 97; j < 97 + n; j++){
                for (int k = 97; k < 97 + n; k++){
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
