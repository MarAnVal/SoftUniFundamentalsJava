import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [] myArr = input.nextLine().split(" ");

        for (int i = 0; i < myArr.length / 2; i++){
            String buffer = myArr[i];
            myArr[i] = myArr[myArr.length - 1 - i];
            myArr[myArr.length - 1 - i] = buffer;
        }
        for (String item : myArr){
            System.out.print(item + " ");
        }
    }
}
