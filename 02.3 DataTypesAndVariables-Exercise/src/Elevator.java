import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Calculate how many courses will be needed to elevate n persons by using an elevator with a capacity of p persons.
        //The input holds two lines: the number of people n and the capacity p of the elevator.
        int people = Integer.parseInt(input.nextLine());
        int capacity = Integer.parseInt(input.nextLine());
        int courses = people / capacity;
        if (people % capacity != 0){
            courses++;
        }
        System.out.println(courses);
    }
}
