import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    private static Object digitToWord(int a) {
        int digit = a % 10;
        String word = "";
        switch (digit){
            case 1:
                word = "one"; break;
            case 2:
                word = "two"; break;
            case 3:
                word = "three"; break;
            case 4:
                word = "four"; break;
            case 5:
                word = "five"; break;
            case 6:
                word = "six"; break;
            case 7:
                word = "seven"; break;
            case 8:
                word = "eight"; break;
            case 9:
                word = "nine"; break;
            case 0:
                word = "zero"; break;
        }
        return word;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        System.out.printf("%s", digitToWord(num));
    }


}
