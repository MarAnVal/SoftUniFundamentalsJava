import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int [] line = new int [n+1];
        int [] buffer = new int[n + 1];
        for (int i = 0; i < n; i++){
            System.arraycopy(line, 0, buffer, 0, n);
            if (i < 2){
                line[i] = 1;
                buffer[i] = line[i];
            } else {
                for (int k = 1; k < i + 1; k ++){
                    line[k] = buffer[k - 1] + buffer[k];
                }
            }

            for (int j = 0; j <= i; j++){
                System.out.print(line[j] + " ");

            }

            System.out.println();

        }
    }
}
