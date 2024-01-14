package Exam02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Read from the console a single line holding space-separated integers.
        List<Integer> numbers =  Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(numbers);
        Collections.reverse(numbers);
        long totalSum = 0;
        for (int element: numbers) {
            totalSum += element;
        }
        double average = 1.0 * totalSum / numbers.size();
        String result = "";
        int start = 5;
        if (numbers.size() < start){
            start = numbers.size();
        }
        for (int i = 0; i < start; i++) {
            if (numbers.get(i) > average){
                result = result + numbers.get(i) + " ";
            }
        }
        if (result.length() == 0 ){
            System.out.println("No");
        } else {
            System.out.print(result);
        }
    }
}
