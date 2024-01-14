import java.util.Locale;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String [] theArr = new String[n];
        for (int i = 0; i < n; i++){
            theArr[i] = input.nextLine();
        }
        int [] intArr = new int[n];
        for (int i = 0; i < n; i++){
            String item = theArr[i];
            int sum = 0;
            String itemLowerCase = item.toLowerCase(Locale.ROOT);
            for (int j = 0; j < item.length(); j++){
                char ch = itemLowerCase.charAt(j);
                char toSum = item.charAt(j);

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    sum += (int) toSum * item.length();
                } else {
                    sum += (int) toSum / item.length();
                }

            }
            intArr[i] = sum;
        }
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if (intArr[i] > intArr[j]){
                    int buffer = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = buffer;
                }
            }
        }

        for (int e : intArr){
            System.out.println(e);
        }
    }
}
