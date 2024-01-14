import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> numbers =Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String commandStr = input.nextLine();

        while(!commandStr.equals("End")) {
            String[] commandArr = commandStr.split(" ");
            switch (commandArr[0]) {
                //· Add {number} - add number at the end
                case "Add":
                    int elementToAdd = Integer.parseInt(commandArr[1]);
                    numbers.add(Integer.valueOf(elementToAdd));
                    break;
                //· Insert {number} {index} - insert number at given index
                case "Insert":
                    int elementToInsert = Integer.parseInt(commandArr[1]);
                    int indexToInsert = Integer.parseInt(commandArr[2]);
                    if (indexToInsert < numbers.size() && indexToInsert >= 0){
                    numbers.add(indexToInsert, elementToInsert);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                //· Remove {index} - remove that index
                //The index given may be outside the array's bounds. In that case, print "Invalid index".
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandArr[1]);
                    if (indexToRemove < numbers.size() && indexToRemove >=0){
                    numbers.remove(indexToRemove);
                    } else
                        System.out.println("Invalid index");
                    break;
                //· Shift left {count} - first number becomes last 'count' times
                //· Shift right {count} - last number becomes first 'count' times
                case "Shift":
                    int indexToShift = 0;
                    int elementToShift = 0;
                    int countOfShift = Integer.parseInt(commandArr[2]);
                    switch (commandArr[1]){
                        case "left":
                            indexToShift = numbers.size() - 1;
                            break;
                        case "right":
                            elementToShift = numbers.size() - 1;
                            break;
                    }
                    for (int i = 0; i < countOfShift; i++) {
                        int numberToAdd = numbers.get(elementToShift);
                        numbers.remove(elementToShift);
                        numbers.add(indexToShift, numberToAdd);
                    }
                    break;

            }
            commandStr = input.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}
