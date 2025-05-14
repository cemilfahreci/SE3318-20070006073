package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(Character character){
        characters.add(character);
    }

    public void StartGame() {
        int turn = 0; boolean gameOver = false; // Violates EmptyLineSeparator
        while (!gameOver) {
            Character attacker = characters.get(turn % characters.size());
            Character defender = characters.get((turn + 1) % characters.size());

            attacker.specialAttack(defender);
            System.out.println(attacker.getName() + " attacks " + defender.getName());

            if (defender.isDefeated()) {
                System.out.println(defender.getName() + " is defeated!");
                gameOver = true; // Use of local variable instead of a method to check game over state
            }

            turn++;
        }
    }

    private boolean isGameOver() {
        for(Character character : characters) {
            if(character.isDefeated()) {
                return true; // Multiple return statements
            }
        }
        return false;
    }
}

