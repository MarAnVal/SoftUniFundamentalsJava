import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoreExe05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String header = input.nextLine();
        String article = input.nextLine();
        String comment = input.nextLine();
        List <String> commentsList = new ArrayList<>();
        while (!comment.equals("end of comments")){
            commentsList.add(comment);
            comment = input.nextLine();
        }

        System.out.printf("<h1>%n    %s%n</h1>%n", header);
        System.out.printf("<article>%n    %s%n</article>%n", article);
        for (String element: commentsList) {
            System.out.printf("<div>%n    %s%n</div>%n", element);
        }
    }
}
