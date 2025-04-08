package org.example;

public class Enemy extends Character {

    public Enemy(String name, int level) {
        super(name, level);
    }

    @Override
    public void speak() {
        System.out.println(name + ": Darkness is eternal. You cannot stop what is already written.");
    }
}