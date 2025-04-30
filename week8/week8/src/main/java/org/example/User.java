package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final String username;
    private final String email;
    private final List<Task> tasks = new ArrayList<>();

    public User(String username, String email) {
        if (username == null || username.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void addTask(Task task) {
        if (task == null || tasks.contains(task)) {
            throw new IllegalArgumentException();
        }
        tasks.add(task);
    }

    public void removeTask(Task task) {
        if (task == null || !tasks.contains(task)) {
            throw new IllegalArgumentException();
        }
        tasks.remove(task);
    }

    public boolean hasTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException();
        }
        return tasks.contains(task);
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(new ArrayList<>(tasks));
    }
}