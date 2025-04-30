package org.example;

import java.time.LocalDate;

public class Task {
    private final String title;
    private final LocalDate dueDate;
    private boolean completed = false;

    public Task(String title, LocalDate dueDate) {
        if (title == null || title.isEmpty() || dueDate == null) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isOverdue() {
        return !completed && LocalDate.now().isAfter(dueDate);
    }

    public void markCompleted() {
        completed = true;
    }
}