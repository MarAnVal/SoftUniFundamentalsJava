import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age = Integer.parseInt(input.nextLine());
        //· 0-2 – baby
        //· 3-13 – child
        //· 14-19 – teenager
        //· 20-65 – adult
        //· >=66 – elder
        //· All the values are inclusive
        if (age >= 0){
            if (age < 3){
                System.out.println("baby");
            } else if (age < 14){
                System.out.println("child");
            } else if (age < 20){
                System.out.println("teenager");
            } else if (age < 66){
                System.out.println("adult");
            } else
                System.out.println("elder");
        }
    }
}
