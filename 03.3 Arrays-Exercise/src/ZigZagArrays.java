import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String [] firstArr = new String[n];
        String [] secondArr = new String[n];

        for (int i = 0; i < n; i++){
            String [] buffer = input.nextLine().split(" ");
            if (i % 2 == 0){
                firstArr[i] = buffer[0];
                secondArr[i] = buffer[1];
            } else {
                firstArr[i] = buffer[1];
                secondArr[i] = buffer[0];
            }
        }
        for(String item: firstArr){
            System.out.printf(item + " ");
        }
        System.out.println();
        for(String item: secondArr){
            System.out.printf(item + " ");
        }
    }
}
