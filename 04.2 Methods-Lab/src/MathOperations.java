import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double number1 = Double.parseDouble(input.nextLine());
        char operator = input.nextLine().charAt(0);
        double number2 = Double.parseDouble(input.nextLine());
        // / * + -
        double result = getResult(number1, number2, operator);
        DecimalFormat df = new DecimalFormat("0.#####");
        System.out.println(df.format(result));
    }
    public static double getResult(double number1, double number2, char operator){
        double result = 0;
        switch (operator){
            case '/':
                result = devide(number1, number2);
                break;
            case '*':
                result = multiply(number1, number2);
                break;
            case '+':
                result = add(number1, number2);
                break;
            case '-':
                result = subtract(number1, number2);
                break;
        }
        return result;
    }
    public static double devide(double number1, double number2){
        return number1 / number2;
    }

    public static double multiply(double number1, double number2){
        return  number1 * number2;
    }

    public static double add(double number1, double number2){
        return number1 + number2;
    }

    public static double subtract(double number1, double number2){
        return number1 - number2;
    }
}
