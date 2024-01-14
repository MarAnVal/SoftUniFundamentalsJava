import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //"add", "multiply", "subtract", "divide
        String command = input.nextLine();
        int firstNum = Integer.parseInt(input.nextLine());
        int secondNum = Integer.parseInt(input.nextLine());
        switch (command){
            case "add":
                add(firstNum,secondNum);
                break;
            case "multiply":
                multiply(firstNum,secondNum);
                break;
            case "subtract":
                subtract(firstNum,secondNum);
                break;
            case "divide":
                devide(firstNum,secondNum);
                break;
        }
    }
    public static void add(int numer1, int number2){
        System.out.println(numer1 + number2);
    }
    public static void multiply(int number1, int number2){
        System.out.println(number1 * number2);
    }
    public static void subtract(int number1, int number2){
        System.out.println(number1 - number2);
    }
    public static void devide(int number1, int number2){
        System.out.println(number1 / number2);
    }

}
