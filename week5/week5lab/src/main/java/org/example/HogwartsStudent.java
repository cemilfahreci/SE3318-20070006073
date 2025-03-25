package org.example;

import java.util.ArrayList;
import java.util.List;

public class HogwartsStudent {
    private String name;
    private int year;
    private String house;
    private List<String> spells;

    public HogwartsStudent(String name, String house, int year) {
        this.name = name;
        this.house = house;
        this.year = year;
        this.spells = new ArrayList<>();
    }

    public boolean learnSpell(String spell) {
        if (spell == null || spells.contains(spell))
            return false;
        spells.add(spell);
        return true;
    }

    public boolean knowsSpell(String spell) {
        return spells.contains(spell);
    }

    public String getName() {
        return name;
    }

    public String getHouse() {
        return house;
    }

    public int getYear() {
        return year;
    }

    public List<String> getSpells() {
        return spells;
    }
}