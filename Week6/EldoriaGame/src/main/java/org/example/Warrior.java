package org.example;

public class Warrior extends Hero implements Questable {

    public Warrior(String name, int level) {
        super(name, level);
    }

    public void attack() {
        System.out.println(getName() + " attacks with a sword!");
    }


    @Override
    public void acceptQuest(String questName) {
        System.out.println(getName() + " the Warrior accepts the quest: " + questName);
    }
}