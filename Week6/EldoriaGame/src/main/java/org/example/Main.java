package org.example;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Aragon", 5);
        Enemy enemy = new Enemy("Skarn the Cruel", 3);

        hero.speak();
        enemy.speak();


        QuestBoard board = new QuestBoard();
        board.assignQuest(hero, "Retrieve the Crystal of Dawn");


        BattleManager battle = new BattleManager();
        battle.startBattle(hero, enemy);
    }
}