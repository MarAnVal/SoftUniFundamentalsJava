import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        //"{first name} {second name} {grade}"
        private String firstName;
        private String lastName;
        private double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public double getGrade() {
            return this.grade;
        }

        @Override
        public String toString() {
            //"{first name} {second name}: {grade}".
            return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· First-line will be a number n.
        int n = Integer.parseInt(input.nextLine());
        //· Next n lines you will get a student info in the format "{first name} {second name} {grade}".
        List<Student> studentsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            //Lakia Eason 3.90
            Student currentStudent = new Student(line.split(" ")[0], line.split(" ")[1],
                    Double.parseDouble(line.split(" ")[2]));
            if (studentsList.isEmpty()) {
                studentsList.add(currentStudent);
            } else {
                for (int j = 0; j < studentsList.size(); j++) {
                    Student element = studentsList.get(j);
                    if (currentStudent.getGrade() > element.getGrade()){
                        studentsList.add(j, currentStudent);
                        break;
                    } else if (j == studentsList.size() - 1){
                        studentsList.add(currentStudent);
                        break;
                    }
                }
            }
        }
        for (Student element: studentsList) {
            System.out.println(element);
        }
    }
}