package org.example;

import java.util.ArrayList;
import java.util.List;

public class Quest {
    private String name;
    private String difficulty;
    private Mentor mentor;
    private List<Adventurer> adventurers;

    public Quest(String name, String difficulty, Mentor mentor) {
        this.name = name;
        this.difficulty = difficulty;
        this.mentor = mentor;
        this.adventurers = new ArrayList<>();
    }

    public void addAdventurer(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    @Override
    public String toString() {
        return "Quest: " + name + " (Difficulty: " + difficulty + "), Mentor: " + mentor;
    }
}