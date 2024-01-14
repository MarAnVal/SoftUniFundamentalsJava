import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());

        char a = ' ';

        for (int i = 0; i < n; i++){
            String newChar = input.nextLine();
            int button = Integer.parseInt(newChar) % 10;
            int index = newChar.length();
            switch (button){
                case 2:
                    switch (index){
                        case 1:
                            a = 'a';
                            break;
                        case 2:
                            a = 'b';
                            break;
                        case 3:
                            a = 'c';
                            break;
                    }
                    break;
                case 3:
                    switch (index){
                        case 1:
                            a = 'd';
                            break;
                        case 2:
                            a = 'e';
                            break;
                        case 3:
                            a = 'f';
                            break;
                    }
                    break;
                case 4:
                    switch (index){
                        case 1:
                            a = 'g';
                            break;
                        case 2:
                            a = 'h';
                            break;
                        case 3:
                            a = 'i';
                            break;
                    }
                    break;
                case 5:
                    switch (index){
                        case 1:
                            a = 'j';
                            break;
                        case 2:
                            a = 'k';
                            break;
                        case 3:
                            a = 'l';
                            break;
                    }
                    break;
                case 6:
                    switch (index){
                        case 1:
                            a = 'm';
                            break;
                        case 2:
                            a = 'n';
                            break;
                        case 3:
                            a = 'o';
                            break;
                    }
                    break;
                case 7:
                    switch (index){
                        case 1:
                            a = 'p';
                            break;
                        case 2:
                            a = 'q';
                            break;
                        case 3:
                            a = 'r';
                            break;
                        case 4:
                            a = 's';
                            break;
                    }
                    break;
                case 8:
                    switch (index){
                        case 1:
                            a = 't';
                            break;
                        case 2:
                            a = 'u';
                            break;
                        case 3:
                            a = 'v';
                            break;
                    }
                    break;
                case 9:
                    switch (index){
                        case 1:
                            a = 'w';
                            break;
                        case 2:
                            a = 'x';
                            break;
                        case 3:
                            a = 'y';
                            break;
                        case 4:
                            a = 'z';
                            break;
                    }
                    break;
            }
            System.out.print(a);
        }

    }
}
