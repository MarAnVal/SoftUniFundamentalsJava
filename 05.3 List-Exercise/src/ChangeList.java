import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String commandStr = input.nextLine();

        while (!commandStr.equals("end")){
            String[] commandArr = commandStr.split(" ");

            switch (commandArr[0]){
                //· Delete {element} - delete all elements in the array which are equal to the given element
                case "Delete":
                    int elementToRemove = Integer.parseInt(commandArr[1]);
                    numbers.removeIf(e -> e == elementToRemove);
                    break;
                    //· Insert {element} {position} - insert element at the given position
                case "Insert":
                    int elementToInsert = Integer.parseInt(commandArr[1]);
                    int index = Integer.parseInt(commandArr[2]);
                    numbers.add(index, elementToInsert);
                    break;
            }

            commandStr = input.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
