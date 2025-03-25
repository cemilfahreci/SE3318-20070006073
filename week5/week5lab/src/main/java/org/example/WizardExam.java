package org.example;

import java.util.List;

public class WizardExam {
    private List<String> requiredSpells;

    public WizardExam(List<String> requiredSpells) {
        this.requiredSpells = requiredSpells;
    }

    public boolean pass(HogwartsStudent student) {
        for (String spell : requiredSpells) {
            if (!student.knowsSpell(spell))
                return false;
        }
        return true;
    }

    public void evaluate(HogwartsStudent student) {
        if (pass(student))
            System.out.println(student.getName() + " has passed the exam!");
        else
            System.out.println(student.getName() + " has failed the exam!");
    }
}