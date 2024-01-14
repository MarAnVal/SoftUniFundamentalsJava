import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
static class Person{
    private String name;
    private String id;
    private int age;

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        //Stephan with ID: 524244 is 10 years old.
        return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
    }
}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        List <Person> personList = new ArrayList<>();

        while (!line.equals("End")){
            //George 123456 20
            Person currentPerson = new Person(line.split(" ")[0], line.split(" ")[1],
                    Integer.parseInt(line.split(" ")[2]));
            personList.add(currentPerson);

            line = input.nextLine();
        }
        personList.sort(Comparator.comparing(Person::getAge));
        for (Person element: personList) {
            System.out.println(element);
        }
    }
}