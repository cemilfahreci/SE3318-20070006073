package org.example;

import java.util.Random;

public class Duel {
    public static void start(HogwartsStudent student1, HogwartsStudent student2, String spell) {
        boolean firstKnows = student1.knowsSpell(spell);
        boolean secondKnows = student2.knowsSpell(spell);

        if (!firstKnows && !secondKnows) {
            System.out.println("The duel is a draw!");
        } else if (firstKnows && !secondKnows) {
            System.out.println(student1.getName() + " wins the duel!");
        } else if (!firstKnows && secondKnows) {
            System.out.println(student2.getName() + " wins the duel!");
        } else {
            Random rand = new Random();
            if (rand.nextBoolean())
                System.out.println(student1.getName() + " wins the duel by magic power!");
            else
                System.out.println(student2.getName() + " wins the duel by magic power!");
        }
    }
}