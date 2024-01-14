import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Write a program that, depending on the first line of the input, reads an int, double, or string.
        String line = input.nextLine();

        switch (line){
            case "int":
                //get inteder and multiply
                int number = Integer.parseInt(input.nextLine());
                printResult(number);
                break;
            case "real":
                double realNumber = Double.parseDouble(input.nextLine());
                printResult(realNumber);
                //get double and multiply; format
                break;
            case "string":
                //get string and surround it with $
                String text = input.nextLine();
                printResult(text);
                break;

        }
    }
    public static void printResult(int number){
        //· If the data type is int, multiply the number by 2.
        int result = number * 2;
        System.out.println(result);
    }

    public static void printResult(double realnumber){
        //· If the data type is real, multiply the number by 1.5 and format it to the second decimal point.
        double result = realnumber * 1.5;
        System.out.printf("%.2f", result);
    }

    public static void printResult(String text){
        String result = "$" + text + "$";
        System.out.println(result);
    }
}
