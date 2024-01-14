import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
static class Person{
    //Peter 12
    private String firstName;
    private int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        //Sam – 31
        return String.format("%s - %d", this.firstName, this.age);
    }
}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List <Person> personsData = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            //Peter 12
            Person currentPerson = new Person(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
            personsData.add(currentPerson);
        }

        for (Person element:personsData) {
            if (element.getAge() > 30){
                System.out.println(element);
            }
        }

    }
}
