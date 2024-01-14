import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        printTriangle(n);

    }
    public static void printLine(int endOfLine){
        for (int i = 1; i <= endOfLine; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void printTriangle(int n){
        for (int i = 1; i < n; i++){
            printLine(i);

        }
        for (int i = n; i > 0; i--){
            printLine(i);
        }
    }
}
