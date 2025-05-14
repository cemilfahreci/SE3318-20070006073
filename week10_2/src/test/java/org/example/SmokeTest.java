package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple smoke tests for specialAttack/defend logic.
 */
public class SmokeTest {

    @Test
    public void testArcherBoostAndAttack() {
        Archer archer = new Archer("Robin", 50, 7);
        Mage dummy = new Mage("Dummy", 40, 0);
        archer.boostAccuracy();
        archer.specialAttack(dummy);
        assertTrue(dummy.getHealth() < 40);
    }

    @Test
    public void testMageShield() {
        Mage mage = new Mage("Gandalf", 30, 5);
        mage.takeDamage(10);
        int left = mage.castShield(12);
        assertEquals(12 - 5, left);
    }

    @Test
    public void testWarriorWarCry() {
        Warrior w = new Warrior("Conan", 60, 6);
        w.warCry();
        // attackPower getter kontrollü; implementasyona göre assert ekle
    }
}