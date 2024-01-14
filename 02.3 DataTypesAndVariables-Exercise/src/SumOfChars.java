import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· On the first line, you will receive n – the number of lines that follow.
        //· On the next n lines – you will receive letters from the Latin alphabet.
        int n = Integer.parseInt(input.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++){
            char letter = input.nextLine().charAt(0);
            sum += (int)letter;
        }
        //Print the total sum in the following format:
        //"The sum equals: {totalSum}"
        System.out.printf("The sum equals: %d", sum);
    }
}
