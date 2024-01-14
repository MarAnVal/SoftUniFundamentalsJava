import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String type = input.nextLine();
        switch (type){
            case "int":
                int number1 = Integer.parseInt(input.nextLine());
                int number2 = Integer.parseInt(input.nextLine());
                System.out.println(getMax(number1, number2));
                break;
            case "char":
                char ch1 = input.nextLine().charAt(0);
                char ch2 = input.nextLine().charAt(0);
                System.out.println(getMax(ch1, ch2));
                break;
            case "string":
                String text1 = input.nextLine();
                String text2 = input.nextLine();
                System.out.println(getMax(text1, text2));
                break;
        }
    }
    public static int getMax(int number1, int number2){
        if (number1 > number2){
            return number1;
        } else
            return number2;
    }
    public static char getMax(char ch1, char ch2){
        int number1 = (int) ch1;
        int number2 = (int) ch2;
        char max = (char) getMax(number1, number2);
        return max;
    }
    public static String getMax(String text1, String text2){
        if(text1.compareTo(text2) > 0){
            return text1;
        } else
            return text2;
    }
}
