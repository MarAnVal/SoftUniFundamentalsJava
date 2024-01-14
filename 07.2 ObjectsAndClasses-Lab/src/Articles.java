import java.util.Scanner;

public class Articles {
    static class Article{
        //· Title – a string
        private String title;
        //· Content – a string
        private String content;
        //· Author – a string
        private String autor;

        public Article(String title, String content, String autor) {
            this.title = title;
            this.content = content;
            this.autor = autor;
        }

        public void rename(String title) {
            this.title = title;
        }

        public void edit(String content) {
            this.content = content;
        }

        public void changeAuthor(String autor) {
            this.autor = autor;
        }

        @Override
        public String toString() {
            //"{title} - {content}: {author}"
            return String.format("%s - %s: %s", this.title, this.content, this.autor);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        //"{title}, {content}, {author}"
        Article theArticle = new Article(line.split(", ")[0], line.split(", ")[1], line.split(", ")[2]);
        int numberOfChanges = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numberOfChanges; i++) {
            String command = input.nextLine();
            //"Edit: {new content}"; "ChangeAuthor: {new author}"; "Rename: {new title}"
            switch (command.split(": ")[0]){
                case "Edit":
                    theArticle.edit(command.split(": ")[1]);
                    break;
                case "ChangeAuthor":
                    theArticle.changeAuthor(command.split(": ")[1]);
                    break;
                case "Rename":
                    theArticle.rename(command.split(": ")[1]);
                    break;
            }

        }
        System.out.println(theArticle);
    }
}
