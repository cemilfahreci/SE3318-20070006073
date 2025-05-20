package com.lordoftherings;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a character in Middle-Earth.
 */
public class Character {
    private String name;
    private String race;
    private int age;
    private String title;
    /**
     * Quests assigned to this character.
     */
    private List<Quest> quests;

    /**
     * Constructs a Character with given attributes.
     *
     * @param name  the character's name
     * @param race  the character's race
     * @param age   the character's age
     * @param title the character's title or role
     */
    public Character(String name, String race, int age, String title) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.title = title;
        this.quests = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Character accepts a quest: adds self to participants and starts the quest.
     *
     * @param quest the quest to accept
     */
    public void acceptQuest(Quest quest) {
        quest.addParticipant(this);
        quest.start();
        quests.add(quest);
    }

    /**
     * Character completes a quest: marks it completed.
     *
     * @param quest the quest to complete
     */
    public void completeQuest(Quest quest) {
        quest.complete();
    }

    /**
     * Returns the list of quests for this character.
     *
     * @return list of quests
     */
    public List<Quest> getQuests() {
        return quests;
    }

    @Override
    public String toString() {
        return name + " the " + title + " (" + race + ", age " + age + ")";
    }
}