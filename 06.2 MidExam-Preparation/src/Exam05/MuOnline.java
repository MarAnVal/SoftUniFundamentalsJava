package Exam05;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [] rooms = input.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        int countRooms = 0;
        boolean dead = false;

        while (countRooms < rooms.length && !dead) {
            String[] currentRoom = rooms[countRooms].split(" ");
            switch (currentRoom[0]){
                case "potion":
                    //"potion"
                    //You are healed with the number in the second part. But your health cannot exceed your initial health (100).
                    //First print: "You healed for {amount} hp."
                    //After that, print your current health: "Current health: {health} hp."
                    int potion = Integer.parseInt(currentRoom[1]);
                    if (health + potion > 100){
                        potion = 100 - health;
                        health = 100;
                    } else {
                        health += potion;
                    }
                    System.out.printf("You healed for %d hp.%n", potion);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    //You've found some bitcoins, the number in the second part.
                    //Print: "You found {amount} bitcoins."
                    int foundBitcoins = Integer.parseInt(currentRoom[1]);
                    bitcoins += foundBitcoins;
                    System.out.printf("You found %d bitcoins.%n", foundBitcoins);
                    break;
                default:
                    //In any other case, you are facing a monster, which you will fight.
                    // The second part of the room contains the attack of the monster. You should remove the monster's attack from your health.
                    //If you are not dead (health <= 0), you've slain the monster, and you should print: "You slayed {monster}."
                    //If you've died, print "You died! Killed by {monster}." and your quest is over.
                    // Print the best room you've manage to reach: "Best room: {room}"
                    String monsterName = currentRoom[0];
                    int monsterPower = Integer.parseInt(currentRoom[1]);
                    health -= monsterPower;
                    if (health > 0){
                        System.out.printf("You slayed %s.%n", monsterName);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", monsterName);
                        System.out.printf("Best room: %d", countRooms + 1);
                        dead = true;
                    }
                    break;

            }
            countRooms++;
        }
        //If you managed to go through all the rooms in the dungeon, print on the following three lines:
        //"You've made it!"
        //"Bitcoins: {bitcoins}"
        //"Health: {health}"
        if(!dead){
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoins, health);
        }
    }
}
