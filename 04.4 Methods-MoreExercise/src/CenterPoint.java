import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [] firstCoordinates = new int[2];
        int [] secondCoordinates = new int[2];
        for (int i = 0; i < 2; i++) {
            firstCoordinates[i] = Integer.parseInt(input.nextLine());
        }
        for (int i = 0; i < 2; i++) {
            secondCoordinates[i] = Integer.parseInt(input.nextLine());
        }
        printResult(firstCoordinates, secondCoordinates);

    }
    // а^2 + b^2 = c^2 Phytagorean theorem
    public static int poweredDistance(int [] arr){
        return arr[0] * arr[0] + arr[1] * arr[1];
    }

    public static void printResult (int [] arr1, int [] arr2){
        if (poweredDistance(arr1) <= poweredDistance(arr2)) {
            printEnd(arr1);
        } else {
            printEnd(arr2);
        }
    }

    public static void printEnd(int [] arr){
        System.out.printf("(%d, %d)", arr[0], arr[1]);
    }
}
