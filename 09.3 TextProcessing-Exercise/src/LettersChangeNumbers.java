import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] lineArr = input.nextLine().split("\\s+");
        double[] resultArr = new double[lineArr.length];

        for (int i = 0; i < lineArr.length; i++) {
            int prefix = (int) lineArr[i].charAt(0);
            int number = Integer.parseInt(lineArr[i].substring(1, lineArr[i].length() - 1));
            int suffix = (int) lineArr[i].charAt(lineArr[i].length() - 1);
            //First, you start with the letter before the number.
            if (prefix > 64 && prefix < 91) {
                //· If it's uppercase, you divide the number by the letter's position in the alphabet.
                prefix -= 64;
                resultArr[i] = number * 1.0 / prefix;
            } else if (prefix > 96 && prefix < 123) {
                //· If it's lowercase, you multiply the number with the letter's position in the alphabet.
                prefix -= 96;
                resultArr[i] = number * 1.0 * prefix;
            }
                //Then you move to the letter after the number.
            if (suffix > 64 && suffix < 91) {
                //· If it's uppercase, you subtract its position from the resulted number.
                suffix -= 64;
                resultArr[i] -= suffix;
            } else if (suffix > 96 && suffix < 123) {
                //· If it's lowercase, you add its position to the resulted number
                suffix -= 96;
                resultArr[i] += suffix;
            }
        }
        double result = 0.0;
        for (Double element: resultArr) {
            result += element;
        }
        System.out.printf("%.2f", result);
    }
}
