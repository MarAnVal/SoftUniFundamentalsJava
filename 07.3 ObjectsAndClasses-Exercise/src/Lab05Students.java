import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab05Students {

    static class Student {
        //John Smith 15 Sofia
        private String firstName;
        private String lastName;
        private int age;
        private String town;

        public Student(String firstName, String lastName, int age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public int getAge() {
            return this.age;
        }

        public String getTown() {
            return this.town;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> studentsList= new ArrayList<>();

        String command = input.nextLine();
        while (!command.equals("end")){
            //John Smith 15 Sofia
            Student currentStudent = new Student(command.split(" ")[0], command.split(" ")[1],
                    Integer.parseInt(command.split(" ")[2]), command.split(" ")[3]);
            studentsList.add(currentStudent);
            command = input.nextLine();
        }
        String commandTown = input.nextLine();
        for (Student element: studentsList) {
            if (element.getTown().equals(commandTown)){
                System.out.println(element);
            }
        }
    }
}

