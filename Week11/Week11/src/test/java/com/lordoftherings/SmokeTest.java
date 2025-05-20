package com.lordoftherings;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Simple smoke tests for project modules.
 */
public class SmokeTest {

    @Test
    public void testCharacter() {
        Character c = new Character("Aragorn", "Human", 87, "Ranger");
        assertEquals("Aragorn", c.getName());
    }

    @Test
    public void testLocation() {
        Location l = new Location("Rivendell", 100, 200);
        assertEquals("Rivendell", l.getName());
    }

    @Test
    public void testQuest() {
        Character c = new Character("Legolas", "Elf", 2931, "Archer");
        List<Character> list = Arrays.asList(c);
        Quest q = new Quest("Rescue", "Medium", list, "Gratitude");
        assertEquals("Medium", q.getDifficulty());
    }

    @Test
    public void testAcceptAndCompleteQuest() {
        Character c = new Character("Frodo", "Hobbit", 50, "Ring-bearer");
        Quest q = new Quest("Destroy Ring", "Hard", new ArrayList<>(), "Peace");
        c.acceptQuest(q);
        assertTrue(q.getParticipants().contains(c));
        assertEquals(QuestStatus.STARTED, q.getStatus());
        c.completeQuest(q);
        assertEquals(QuestStatus.COMPLETED, q.getStatus());
    }
}