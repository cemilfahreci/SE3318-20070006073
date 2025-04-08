package org.example;

public class QuestBoard {
    public void assignQuest(Questable character, String questName) {
        System.out.println("The quest \"" + questName + "\" has been issued. A new chapter begins.");
        character.acceptQuest(questName);
    }
}