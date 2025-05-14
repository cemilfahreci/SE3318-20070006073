package org.example;

/**
 * Spellcaster that can cast a protective shield.
 */
public class Mage extends Character {

    public Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void specialAttack(Character opponent) {
        int damage = getAttackPower() + 10;
        opponent.takeDamage(damage);
    }

    /**
     * Casts a shield, absorbs 5 damage.
     *
     * @param incomingDamage original damage
     * @return remaining damage after shield
     */
    public int castShield(int incomingDamage) {
        int actual = Math.max(0, incomingDamage - 5);
        takeDamage(actual);
        return actual;
    }
}