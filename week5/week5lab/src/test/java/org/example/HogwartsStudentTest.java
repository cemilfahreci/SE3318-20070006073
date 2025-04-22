package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HogwartsStudentTest {
    private HogwartsStudent student;

    @Before
    public void setup() {
        student = new HogwartsStudent("Hermione", "Gryffindor", 3);
    }

    @Test
    public void testLearnValidSpell() {
        assertTrue(student.learnSpell("Alohomora"));
        assertTrue(student.knowsSpell("Alohomora"));
    }

    @Test
    public void testLearnNullSpell() {
        assertFalse(student.learnSpell(null));
        assertTrue(student.getSpells().isEmpty());
    }

    @Test
    public void testLearnDuplicateSpell() {
        student.learnSpell("Wingardium Leviosa");
        assertFalse(student.learnSpell("Wingardium Leviosa"));
        assertEquals(1, student.getSpells().size());
    }

    @Test
    public void testKnowsSpell() {
        student.learnSpell("Expecto Patronum");
        assertTrue(student.knowsSpell("Expecto Patronum"));
        assertFalse(student.knowsSpell("UnknownSpell"));
    }
}