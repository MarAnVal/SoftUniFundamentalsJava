import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //English is spoken in England and USA
        //Spanish is spoken in Spain, Argentina, and Mexico
        //for the others, we should print "unknown".
        String country = input.nextLine();

        switch (country){
            case "England":
            case"USA":
                System.out.println("English");break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.println("Spanish"); break;
            default:
                System.out.println("unknown"); break;
        }

    }
}
