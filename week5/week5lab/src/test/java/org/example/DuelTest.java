package org.example;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class DuelTest {
    private HogwartsStudent a, b;

    @Before
    public void setup() {
        a = new HogwartsStudent("A", "X", 1);
        b = new HogwartsStudent("B", "Y", 1);
        a.learnSpell("Spell1");
        b.learnSpell("Spell1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArgs() {
        Duel.start(null, b, "Spell1");
    }

    @Test
    public void testNeitherKnows() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Duel.start(a, b, "Unknown");
        assertTrue(out.toString().contains("draw"));
    }

    @Test
    public void testOneKnows() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        b.learnSpell("Magic");
        Duel.start(a, b, "Magic");
        assertTrue(out.toString().contains("B wins"));
    }

    @Test
    public void testBothKnowRandomOutcome() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Duel.start(a, b, "Spell1");
        String res = out.toString();
        assertTrue(res.contains("wins the duel"));
    }
}