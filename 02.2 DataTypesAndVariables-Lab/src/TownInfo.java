import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will be given 3 lines of input.
        // first line, you will be given the name of the town
        // second – the population,
        // third – the area
        // Use the correct data types and print the result in the following format:
        //"Town {town name} has population of {population} and area {area} square km.".
        String name = input.nextLine();
        int population = Integer.parseInt(input.nextLine());
        int area = Integer.parseInt(input.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.", name, population, area);
    }
}
