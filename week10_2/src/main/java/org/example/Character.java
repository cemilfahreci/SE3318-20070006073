package org.example;

/**
 * Abstract base for all game characters.
 */
public abstract class Character {

    /** Character’s name. */
    private String name;

    /** Current health points. */
    private int health;

    /** Base attack power. */
    private int attackPower;

    /**
     * Constructs a new character.
     *
     * @param name        character’s name
     * @param health      starting health
     * @param attackPower base attack power
     */
    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    /**
     * Returns the character’s name.
     *
     * @return name or "Unknown" if null
     */
    public String getName() {
        return name != null ? name : "Unknown";
    }

    /**
     * Returns current health.
     *
     * @return health points
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns base attack power.
     *
     * @return attack power
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Reduces health by given damage.
     *
     * @param damage amount to subtract
     */
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    /**
     * Character performs its special attack on opponent.
     *
     * @param opponent target character
     */
    public abstract void specialAttack(Character opponent);

    /**
     * Defends, reducing incoming damage by half.
     *
     * @param damage incoming damage
     * @return actual damage taken
     */
    public int defend(int damage) {
        int actual = damage / 2;
        takeDamage(actual);
        return actual;
    }

    /**
     * Checks if character is out of health.
     *
     * @return true if health ≤ 0
     */
    public boolean isDefeated() {
        return health <= 0;
    }
}