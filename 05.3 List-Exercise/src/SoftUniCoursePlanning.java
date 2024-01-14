import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first input line, you will receive the initial schedule of lessons and exercises that will be part of the next course,
        //separated by a comma and space ", ".
        List<String> lessons = Arrays.stream(input.nextLine().split(", ")).collect(Collectors.toList());
        String modify = input.nextLine();
        // before the course starts, there are some changes to be made. Until you receive "course start",
        // you will be given some commands to modify the course schedule
        while(!modify.equals("course start")){
            String[] commands = modify.split(":");
            switch (commands[0]) {
                //Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
                case "Add":
                    if(!lessons.contains(commands[1])){
                        lessons.add(commands[1]);
                    }
                    break;
                //Insert:{lessonTitle}:{index} - insert the lesson to the given index, if it does not exist
                case "Insert":
                    if(!lessons.contains(commands[1])){
                        int index = Integer.parseInt(commands[2]);
                        lessons.add(index, commands[1]);
                    }
                    break;
                //Remove:{lessonTitle} - remove the lesson, if it exists
                //Each time you Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.
                case "Remove":
                    if (lessons.contains(commands[1])){
                        lessons.remove(commands[1]);
                        lessons.remove(commands[1] + "-Exercise");
                    }
                    break;
                //Swap:{lessonTitle}:{lessonTitle} - change the place of the two lessons, if they exist
                //Each time you Swap a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.
                case "Swap":
                    if (lessons.contains(commands[1]) && lessons.contains(commands[2])) {
                        boolean firstHaveExercise = lessons.remove(commands[1] + "-Exercise");
                        boolean secondHaveExercise = lessons.remove(commands[2] + "-Exercise");
                        int firstIndex = lessons.indexOf(commands[1]);
                        int secondIndex = lessons.indexOf(commands[2]);
                        lessons.set(secondIndex, commands[1]);
                        lessons.set(firstIndex, commands[2]);
                        if (secondHaveExercise){
                            lessons.add(lessons.indexOf(commands[2]) + 1, commands[2] + "-Exercise");
                        }
                        if (firstHaveExercise){
                            lessons.add(lessons.indexOf(commands[1]) + 1, commands[1] + "-Exercise");
                        }
                    }
                    break;
                //Exercise:{lessonTitle} - add Exercise in the schedule right after the lesson index,
                // if the lesson exists and there is no exercise already, in the following format "{lessonTitle}-Exercise".
                // If the lesson doesn't exist, add the lesson at the end of the course schedule, followed by the Exercise.
                case "Exercise":
                    if(lessons.contains(commands[1]) && !lessons.contains(commands[1] + "-Exercise")){
                        if (lessons.indexOf(commands[1]) == lessons.size() - 1){
                            lessons.add(commands[1] + "-Exercise");
                        } else {
                            lessons.add(lessons.indexOf(commands[1]) + 1, commands[1] + "-Exercise");
                        }
                    } else if (!lessons.contains(commands[1])){
                        lessons.add(commands[1]);
                        lessons.add(commands[1] + "-Exercise");
                    }
                    break;
            }
            modify = input.nextLine();
        }
        for (int i = 0; i < lessons.size(); i++) {
            System.out.println(i+1 + "." + lessons.get(i));
        }
    }
}

