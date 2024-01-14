package Exam03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String commandStr = input.nextLine();

        while(!commandStr.equals("End")) {
            String[] commandArr = commandStr.split(" ");
            switch (commandArr[0]) {
                case "Shoot":
                //"Shoot {index} {power}"
                //Shoot the target at the index if it exists by reducing its value by the given power (integer value).
                //Remove the target if it is shot. A target is considered shot when its value reaches 0.
                    int shootIndex = Integer.parseInt(commandArr[1]);
                    if (shootIndex >= 0 && shootIndex < targets.size()){
                        int shootPower = Integer.parseInt(commandArr[2]);
                        int shootTarget = targets.get(shootIndex);
                        if (shootTarget - shootPower <= 0){
                            targets.remove(shootIndex);
                        } else {
                            targets.set(shootIndex, shootTarget - shootPower);
                        }
                    }
                    break;
                case "Add":
                    //"Add {index} {value}"
                    //Insert a target with the received value at the received index if it exists.
                    //If not, print: "Invalid placement!"
                    int addIndex = Integer.parseInt(commandArr[1]);
                    if (addIndex >= 0 && addIndex < targets.size()){
                        int addValue = Integer.parseInt(commandArr[2]);
                        targets.add(addIndex, addValue);
                    } else if (targets.isEmpty() && addIndex == 0){
                        int addValue = Integer.parseInt(commandArr[2]);
                        targets.add(addIndex, addValue);
                    } else{
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    //"Strike {index} {radius}"
                    //Remove the target at the given index and the ones before and after it depending on the radius.
                    //If any of the indices in the range is invalid, print: "Strike missed!" and skip this command.
                    int strikeIndex = Integer.parseInt(commandArr[1]);
                    int strikeRadius = Integer.parseInt(commandArr[2]);
                    if (strikeIndex - strikeRadius >= 0 && strikeIndex + strikeRadius < targets.size()){
                        int removeIndex = strikeIndex - strikeRadius;
                        int turns = strikeRadius * 2 + 1;
                        for (int i = 0; i < turns; i++) {
                            targets.remove(removeIndex);
                        }
                    }else {
                        System.out.println("Strike missed!");
                    }

                    break;
            }
            commandStr = input.nextLine();
        }
        //"End"
        //Print the sequence with targets in the following format and end the program:
        //"{target1}|{target2}…|{targetn}"
        String result = "";
        for (int i = 0; i < targets.size(); i++) {
            if (i == targets.size() - 1){
                result = result + targets.get(i);
            } else {
                result = result + targets.get(i) + "|";
            }
        }
        System.out.println(result);
    }
}
