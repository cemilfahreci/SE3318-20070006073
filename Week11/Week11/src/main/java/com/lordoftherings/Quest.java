package com.lordoftherings;

import java.util.List;

/**
 * Represents a quest.
 */
public class Quest {
    private String type;
    private String difficulty;
    private List<Character> participants;
    private String reward;
    /**
     * The current status of the quest.
     */
    private QuestStatus status;

    /**
     * Constructs a Quest.
     *
     * @param type         quest type (e.g. Rescue, Escort)
     * @param difficulty   difficulty level
     * @param participants list of characters on the quest
     * @param reward       reward for completing
     */
    public Quest(String type, String difficulty, List<Character> participants, String reward) {
        this.type = type;
        this.difficulty = difficulty;
        this.participants = participants;
        this.reward = reward;
        this.status = QuestStatus.NOT_STARTED;
    }

    public String getType() {
        return type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public List<Character> getParticipants() {
        return participants;
    }

    public String getReward() {
        return reward;
    }

    /**
     * Returns the current status of this quest.
     *
     * @return the quest status
     */
    public QuestStatus getStatus() {
        return status;
    }

    /**
     * Marks this quest as started.
     */
    public void start() {
        this.status = QuestStatus.STARTED;
    }

    /**
     * Marks this quest as completed.
     */
    public void complete() {
        this.status = QuestStatus.COMPLETED;
    }

    /**
     * Adds a participant to this quest.
     *
     * @param character the character to add
     */
    public void addParticipant(Character character) {
        participants.add(character);
    }

    @Override
    public String toString() {
        return "Quest[type=" + type +
                ", difficulty=" + difficulty +
                ", reward=" + reward +
                ", status=" + status + "]";
    }
}