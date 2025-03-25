package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HogwartsStudent harry = new HogwartsStudent("Harry Potter", "Gryffindor", 5);
        HogwartsStudent luna = new HogwartsStudent("Luna Lovegood", "Ravenclaw", 5);
        HogwartsStudent draco = new HogwartsStudent("Draco Malfoy", "Slytherin", 5);

        harry.learnSpell("Expelliarmus");
        harry.learnSpell("Protego");
        luna.learnSpell("Lumos");
        luna.learnSpell("Accio");
        draco.learnSpell("Cruciatus Curse");

        SpellBook spellBook = new SpellBook();
        spellBook.addSpell("Expelliarmus");
        spellBook.addSpell("Accio");
        spellBook.addSpell("Lumos");
        spellBook.addSpell("Cruciatus Curse");
        spellBook.addSpell("Protego");

        MagicClassroom classroom = new MagicClassroom();
        classroom.addStudent(harry);
        classroom.addStudent(luna);
        classroom.addStudent(draco);

        WizardExam exam = new WizardExam(Arrays.asList("Expelliarmus", "Protego"));
        exam.evaluate(harry);
        exam.evaluate(luna);
        exam.evaluate(draco);

        Duel.start(harry, draco, "Expelliarmus");
        Duel.start(luna, draco, "Cruciatus Curse");
        Duel.start(harry, luna, "Accio");
    }
}