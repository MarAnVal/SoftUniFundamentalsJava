package Exam03;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line of input, you will receive a sequence of integers, separated by a single space – the targets sequence.
        //On the following lines, until the "End" command, you be receiving integers each on a single line – the index of the target to be shot.
        int [] targets = Arrays.stream(input.nextLine().split(" ")). mapToInt(Integer::parseInt).toArray();
        int [] doneShots = new int[targets.length];
        String commandStr = input.nextLine();

        while (!commandStr.equals("End")){
            int shotIndex = Integer.parseInt(commandStr);
            if(shotIndex >=0 && shotIndex < doneShots.length){
                if(doneShots[shotIndex] != -1){
                    int element = targets[shotIndex];
                    doneShots[shotIndex] = -1;
                    for (int i = 0; i < targets.length; i++) {
                        if (targets[i] > element){
                            //Reduce all the other targets, which have greater values than your current target, with its value.
                            targets[i] -= element;
                        } else {
                            //Increase all the other targets, which have less than or equal value to the shot target, with its value.
                            targets[i] += element;
                        }
                    }
                }
            }
            commandStr = input.nextLine();
        }
        int count = 0;
        for (int i = 0; i < doneShots.length; i++) {
            if (doneShots[i] != -1){
                doneShots[i] = targets[i];
            } else {
                count++;
            }
        }
        //"Shot targets: {count} -> {target1} {target2}… {targetn}"
        System.out.printf("Shot targets: %d -> ", count);
        for (int element:doneShots) {
            System.out.print(element + " ");
        }
    }
}
