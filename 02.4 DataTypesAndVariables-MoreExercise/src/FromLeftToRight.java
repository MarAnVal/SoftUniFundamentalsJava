import java.math.BigDecimal;
import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will receive a number representing how many lines we will get as input.
        //On the next N lines, you will receive a string with 2 numbers separated by a single space.
        //You need to compare them and for the greater one print the sum of all digits number.
        int lineNumber = Integer.parseInt(input.nextLine());

        for (int j = 0; j < lineNumber; j++){

            String line = input.nextLine();
            double num1 = 0;
            double  num2 = 0;
            String buffer = "";
              for (int k = 0; k < line.length(); k++){
                  if (line.charAt(k) == ' '){
                      num1 = Double.parseDouble(line.substring(0, k));
                      buffer = line.substring(0, k);
                      num2 = Double.parseDouble(line.substring(k + 1, line.length()));
                      line = line.substring(k + 1, line.length());
                      break;
                  }
              }
            BigDecimal sum = new BigDecimal(0);
            if (num1 > num2){
               line = buffer;
            }
            for (int h = 0; h < line.length(); h++){
                char ch = line.charAt(h);
                if (Character.isDigit(ch)){
                int digit = (int) ch;
                digit -= 48;
                sum = sum.add(BigDecimal.valueOf(digit));
                }
            }
            System.out.println(sum);
        }
    }
}
