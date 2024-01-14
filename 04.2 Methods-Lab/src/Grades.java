import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double grade = Double.parseDouble(input.nextLine());
        printGradeWords(grade);

    }
    public static void printGradeWords (double n){
        //· 2.00 – 2.99 - "Fail"
        //· 3.00 – 3.49 - "Poor"
        //· 3.50 – 4.49 - "Good"
        //· 4.50 – 5.49 - "Very good"
        //· 5.50 – 6.00 - "Excellent"
        if (n >=2 && n < 3){
            System.out.println("Fail");
        } else if (n < 3.5){
            System.out.println("Poor");
        }else if (n < 4.5){
            System.out.println("Good");
        }else if (n < 5.5){
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }
    }
}
