import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    static class Message {
        //{phrase} {event} {author} – {city}.
        private String phrase;
        private String event;
        private String author;
        private String city;

        public Message() {
            String [] phraseArr = {"Excellent product.", "Such a great product.", "I always use that product.",
                    "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
            String [] eventArr = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                    "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
            String [] authorArr = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
            String [] cityArr = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
            Random rnd = new Random();
            this.phrase = phraseArr[rnd.nextInt(phraseArr.length)];
            this.event = eventArr[rnd.nextInt(eventArr.length)];
            this.author = authorArr[rnd.nextInt(authorArr.length)];
            this.city = cityArr[rnd.nextInt(cityArr.length)];
        }

        @Override
        public String toString() {
            //{phrase} {event} {author} – {city}.
            return String.format("%s %s %s – %s.", this.phrase, this.event, this.author, this.city);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            //{phrase} {event} {author} – {city}.
            Message currentMessage = new Message();
            System.out.println(currentMessage);
        }

    }
}
