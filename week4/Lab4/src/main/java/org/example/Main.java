package org.example;

public class Main {
    public static void main(String[] args) {
        Mentor kelmar = new Mentor("Kelmar", "The Wise");
        Mentor elmir = new Mentor("Elmir", "Lord of the Citadel");

        Quest retrieveCrystal = new Quest("Retrieve the Crystal", "Hard", kelmar);
        Quest slayDragon = new Quest("Slay the Dragon", "Medium", elmir);

        Adventurer aris = new Adventurer("Aris", "Stormborn", "Human");
        Adventurer leon = new Adventurer("Leon", "Shadow Walker", "Human");
        Adventurer tera = new Adventurer("Tera", "Sharpshooter", "Elf");
        Adventurer bran = new Adventurer("Bran", "Axe Wielder", "Dwarf");

        aris.joinQuest(retrieveCrystal);
        leon.joinQuest(retrieveCrystal);
        tera.joinQuest(slayDragon);
        bran.joinQuest(slayDragon);

        kelmar.assignQuest(retrieveCrystal);
        elmir.assignQuest(slayDragon);

        System.out.println(retrieveCrystal);
        for (Adventurer adv : retrieveCrystal.getAdventurers()) {
            System.out.println(" - " + adv);
        }

        System.out.println();

        System.out.println(slayDragon);
        for (Adventurer adv : slayDragon.getAdventurers()) {
            System.out.println(" - " + adv);
        }
    }
}