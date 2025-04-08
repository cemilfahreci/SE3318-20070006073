package org.example;

public abstract class Character {
    protected String name;
    protected int level;

    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public abstract void speak();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}