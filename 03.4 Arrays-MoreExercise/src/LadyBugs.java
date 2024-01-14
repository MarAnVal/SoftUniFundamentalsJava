import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void fullField(int [] arr, String stt) {
        int [] ladyBugsIndexArr = Arrays.stream(stt.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int index : ladyBugsIndexArr) {
            if (index >= 0 && index < arr.length) {
                arr[index] = 1;
            }
        }

    }
    public static void rightFly (int [] arr, String stt, int maxField){
        int [] parameters = Arrays.stream(stt.split(" right ")).mapToInt(Integer::parseInt).toArray();
        int index = parameters[0];
        int steps = Math.abs(parameters[1]);

        if (index >= 0 && index < maxField) {
            if (arr[index] == 1) {
                arr[index] = 0;
                while (index >= 0 && index < maxField) {
                    if (index + steps < arr.length) {
                        if (arr[index + steps] != 1) {
                            arr[index + steps] = 1;
                            break;
                        } else {
                            index += steps;
                        }
                    } else
                        index += steps;

                }
            }
        }
    }
    public static void leftFly(int [] arr, String stt, int maxField){
        int [] parameters = Arrays.stream(stt.split(" left ")).mapToInt(Integer::parseInt).toArray();
        int index = parameters[0];
        int steps = Math.abs(parameters[1]);
        if (index >= 0 && index < maxField) {
            if (arr[index] == 1) {
                arr[index] = 0;
                while (index >= 0 && index < maxField) {
                    if (index - steps >= 0) {
                        if (arr[index - steps] == 0) {
                            arr[index - steps] = 1;
                            break;
                        } else {
                            index -= steps;
                        }
                    } else
                        index -= steps;
                }
            }
        }
    }
    public static void fly (int [] arr, String whatToDo, int maxField){
        String [] commands = whatToDo.split(" ");
        switch (commands[1]){
            case "right":
                if (commands[2].charAt(0) == '-'){
                    whatToDo = whatToDo.replaceAll("right", "left");
                    leftFly(arr, whatToDo, maxField);
                } else {
                    rightFly(arr, whatToDo, maxField);
                    return;
                }
                break;
            case "left":
                if (commands[2].charAt(0) == '-'){
                    whatToDo = whatToDo.replaceAll("left", "right");
                    rightFly(arr, whatToDo, maxField);
                } else {
                    leftFly(arr, whatToDo, maxField);
                    return;
                }
                break;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fieldMax = Integer.parseInt(input.nextLine());
        int [] field = new int [fieldMax];
        String ladyBugsIndex = input.nextLine();

        fullField(field, ladyBugsIndex);

        String whatToDo = input.nextLine();
        int countCommands = 1;


        while (!(whatToDo.equals("end")) && countCommands!=100){

            fly(field, whatToDo, fieldMax);

            whatToDo = input.nextLine();
            countCommands++;
         }
        for (int e : field){
            System.out.print(e + " ");
        }
    }
}
