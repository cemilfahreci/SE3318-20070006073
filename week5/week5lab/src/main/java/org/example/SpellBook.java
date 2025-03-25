package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpellBook {
    private List<String> spellList;

    public SpellBook() {
        spellList = new ArrayList<>();
    }

    public void addSpell(String spell) {
        if (spell != null)
            spellList.add(spell);
    }

    public String getSpellAt(int index) {
        return spellList.get(index);
    }

    public List<String> getSpellsStartingWith(String prefix) {
        List<String> results = new ArrayList<>();
        for (String s : spellList) {
            if (s.startsWith(prefix))
                results.add(s);
        }
        return results;
    }
}