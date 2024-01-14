package Exam04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, Integer> heroHPMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> heroMPMap = new LinkedHashMap<>();
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            //"{hero name} {HP} {MP}"
            //HP stands for hit points and MP for mana points
            //a hero can have a maximum of 100 HP and 200 MP
            String hero = line.split("\\s+")[0];
            int hp = Integer.parseInt(line.split("\\s+")[1]);
            int mp = Integer.parseInt(line.split("\\s+")[2]);
            heroHPMap.putIfAbsent(hero, hp);
            heroMPMap.putIfAbsent(hero, mp);
        }
        String line = input.nextLine();
        while (!line.equals("End")) {
            String command = line.split(" - ")[0];
            String hero = line.split(" - ")[1];
            switch (command) {
                //"CastSpell – {hero name} – {MP needed} – {spell name}"
                case "CastSpell":
                    int neededMP = Integer.parseInt(line.split(" - ")[2]);
                    String spellName = line.split(" - ")[3];
                    int mp = heroMPMap.get(hero);
                    mp -= neededMP;
                    if (mp >= 0) {
                        //If the hero has the required MP, he casts the spell, thus reducing his MP. Print this message:
                        //"{hero name} has successfully cast {spell name} and now has {mana points left} MP!"
                        heroMPMap.put(hero, mp);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                hero, spellName, mp);
                    } else {
                        //If the hero is unable to cast the spell print:
                        //"{hero name} does not have enough MP to cast {spell name}!"
                        System.out.printf("%s does not have enough MP to cast %s!%n", hero, spellName);
                    }
                    break;
                //"TakeDamage – {hero name} – {damage} – {attacker}"
                case "TakeDamage":
                    int damage = Integer.parseInt(line.split(" - ")[2]);
                    String attacker = line.split(" - ")[3];
                    //Reduce the hero HP by the given damage amount. If the hero is still
                    int health = heroHPMap.get(hero);
                    health -= damage;
                    if (health > 0) {
                        // alive (his HP is greater than 0) print:
                        //"{hero name} was hit for {damage} HP by {attacker} and now has {current HP} HP left!"
                        heroHPMap.put(hero, health);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                hero, damage, attacker, health);
                    } else {
                        //If the hero has died, remove him from your party and print:
                        //"{hero name} has been killed by {attacker}!"
                        System.out.printf("%s has been killed by %s!%n", hero, attacker);
                        heroHPMap.remove(hero);
                        heroMPMap.remove(hero);
                    }
                    break;
                //"Recharge – {hero name} – {amount}"
                case "Recharge":
                    int amountMP = Integer.parseInt(line.split(" - ")[2]);
                    int mana = heroMPMap.get(hero);
                    if (mana + amountMP > 200) {
                        //The hero increases his MP. If it brings the MP of the hero above the maximum value (200),
                        // MP is increased to 200. (the MP can't go over the maximum value).
                        int more = 200 - (amountMP + mana);
                        amountMP += more;
                        mana = 200;
                    } else {
                        mana = mana + amountMP;
                    }
                    // Print the following message:
                    //"{hero name} recharged for {amount recovered} MP!"
                    heroMPMap.put(hero, mana);
                    System.out.printf("%s recharged for %d MP!%n", hero, amountMP);
                    break;
                //"Heal – {hero name} – {amount}"
                case "Heal":
                    int amountHP = Integer.parseInt(line.split(" - ")[2]);
                    int hp = heroHPMap.get(hero);
                    if (hp + amountHP > 100) {
                        //The hero increases his HP. If a command is given that would bring the HP of the hero above
                        // the maximum value (100), HP is increased to 100 (the HP can't go over the maximum value).
                        int extra = 100 - (hp + amountHP);
                        amountHP += extra;
                        hp = 100;
                    } else {
                        hp = hp + amountHP;
                    }
                // Print the following message:
                //"{hero name} healed for {amount recovered} HP!"
                    heroHPMap.put(hero, hp);
                    System.out.printf("%s healed for %d HP!%n", hero, amountHP);
                    break;
            }

            line = input.nextLine();
        }
        //"{hero name}
        //  HP: {current HP}
        //  MP: {current MP}"
        for (Map.Entry<String, Integer> entry : heroHPMap.entrySet()) {
            String hero = entry.getKey();
            int hp = entry.getValue();
            int mp = heroMPMap.get(hero);
            System.out.println(hero);
            System.out.printf("  HP: %d%n", hp);
            System.out.printf("  MP: %d%n", mp);
        }

    }
}
