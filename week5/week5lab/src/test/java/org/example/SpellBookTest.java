package org.example;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class SpellBookTest {
    private SpellBook book;

    @Before
    public void setup() {
        book = new SpellBook();
        book.addSpell("Accio");
        book.addSpell("Alohomora");
        book.addSpell("Avada Kedavra");
    }

    @Test
    public void testGetSpellAtValidIndex() {
        assertEquals("Alohomora", book.getSpellAt(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSpellAtInvalidIndex() {
        book.getSpellAt(10);
    }

    @Test
    public void testGetSpellsStartingWithExact() {
        List<String> results = book.getSpellsStartingWith("Alo");
        assertEquals(1, results.size());
        assertEquals("Alohomora", results.get(0));
    }

    @Test
    public void testGetSpellsStartingWithEmptyPrefix() {
        List<String> all = book.getSpellsStartingWith("");
        assertEquals(3, all.size());
    }

    @Test
    public void testGetSpellsStartingWithNoMatch() {
        assertTrue(book.getSpellsStartingWith("Xyz").isEmpty());
    }
}