package org.example;

public abstract class Character {
    protected String name;
    protected String title;

    public Character(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " " + name;
    }
}