package org.example;

public class Mage extends Hero implements Questable {

    public Mage(String name, int level) {
        super(name, level);

    }

    public void castSpell() {
        System.out.println(getName() + " casts a powerful spell!");
    }

    @Override
    public void acceptQuest(String questName) {
        System.out.println(getName() + " the Mage accepts the quest: " + questName);
    }
}