import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        printMatrixN(n);
    }
    public static void printMatrixN(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
