package org.example;

/**
 * Ranged attacker that can boost accuracy.
 */
public class Archer extends Character {

    /**
     * Builds an Archer.
     *
     * @param name        name
     * @param health      health
     * @param attackPower base attack
     */
    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void specialAttack(Character opponent) {
        int damage = getAttackPower() + 5;
        opponent.takeDamage(damage);
    }

    /**
     * Temporarily increases attack power.
     */
    public void boostAccuracy() {
        // örnek: +3 attack gücü
        // gerçekleştirmeyi kendine göre tamamla
    }
}