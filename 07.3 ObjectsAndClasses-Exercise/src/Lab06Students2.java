import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab06Students2 {
    static class Studen {
        //John Smith 15 Sofia
        private String firstName;
        private String lastName;
        private int age;
        private String town;

        public Studen(String firstName, String lastName, int age, String town) {
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

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Studen> studentsList = new ArrayList<>();

        String command = input.nextLine();
        while (!command.equals("end")) {
            //John Smith 15 Sofia
            Studen currentStudent = new Studen(command.split(" ")[0], command.split(" ")[1],
                    Integer.parseInt(command.split(" ")[2]), command.split(" ")[3]);
                boolean isEdited = false;
                for (Studen element : studentsList) {

                    if (currentStudent.getFirstName().equals(element.getFirstName()) && currentStudent.getLastName().equals(element.getLastName())) {
                        element.setAge(currentStudent.getAge());
                        element.setTown(currentStudent.getTown());
                        isEdited = true;
                        break;
                    }
                }
                if (!isEdited){
                    studentsList.add(currentStudent);
            }

            command = input.nextLine();
        }

        String commandTown = input.nextLine();
        for (Studen element : studentsList) {
            if (element.getTown().equals(commandTown)) {
                System.out.println(element);
            }
        }
    }
}



