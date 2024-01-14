import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    static class Song {
        //Type List, Name, and Time.
        private String typeList;
        private String name;
        private String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return this.typeList;
        }

        public String getName() {
            return this.name;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Song> songList = new ArrayList<>();
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            //"{typeList}_{name}_{time}".
            Song currentSong = new Song(line.split("_")[0], line.split("_")[1], line.split("_")[2]);
            songList.add(currentSong);
        }
        String command = input.nextLine();

        if (command.equals("all")){
            for (Song element: songList) {
                System.out.println(element.getName());
            }
        } else {
            for (Song element: songList) {
                if (element.getTypeList().equals(command)){
                    System.out.println(element.getName());
                }
            }
        }

    }
}
