package org.example;

public class Hero extends Character implements Questable {

    public Hero(String name, int level) {
        super(name, level);
    }

    @Override
    public void speak() {
        System.out.println(name + ": My blade is sworn to protect Eldoria. I will not falter.");
    }

    @Override
    public void acceptQuest(String questName) {
        System.out.println(name + " has accepted the quest: \"" + questName + "\"");
    }
}