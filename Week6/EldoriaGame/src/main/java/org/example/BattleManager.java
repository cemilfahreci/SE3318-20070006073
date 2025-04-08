package org.example;

public class BattleManager {
    public void startBattle(Hero hero, Enemy enemy) {
        System.out.println("The silence breaks as " + hero.getName() + " confronts " + enemy.getName() + " on the battlefield.");

        if (hero.getLevel() >= enemy.getLevel()) {
            System.out.println(hero.getName() + " stands victorious. Light prevails this day.");
        } else {
            System.out.println(hero.getName() + " has fallen. Darkness claims another soul.");
        }
    }
}