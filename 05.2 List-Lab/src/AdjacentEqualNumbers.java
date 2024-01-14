import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Double> line = Arrays.stream(input.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        for (int i = 0; i < line.size() - 1; i++) {
            double number1 = line.get(i);
            double number2 = line.get(i + 1);
            if(number1 == number2){
                line.set(i, number1 + number2);
                line.remove(i+1);
                i = -1;
            }
        }
        DecimalFormat df = new DecimalFormat("0.##");
        String lineString = "";
        for (double element: line) {
            lineString = lineString + df.format(element) + " ";
        }
        System.out.println(lineString);
    }
}
