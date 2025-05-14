package org.example;

/**
 * Melee fighter that can rally with a war cry.
 */
public class Warrior extends Character {

    public Warrior(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void specialAttack(Character opponent) {
        int damage = getAttackPower() + 8;
        opponent.takeDamage(damage);
    }

    /**
     * Shouts a war cry, increasing own attack power by 2.
     */
    public void warCry() {
        // örnek: kalıcı veya geçici +2 attack
        // uygulamayı kendine göre yap
    }
}