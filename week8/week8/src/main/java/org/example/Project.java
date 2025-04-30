package org.example;

import java.util.*;

public class Project {
    private final Set<User> users = new HashSet<>();
    private final List<Task> tasks = new ArrayList<>();

    public void addUser(User user) {
        if (user == null || users.contains(user)) {
            throw new IllegalArgumentException();
        }
        users.add(user);
    }

    public void addTask(Task task) {
        if (task == null || tasks.contains(task)) {
            throw new IllegalArgumentException();
        }
        tasks.add(task);
    }

    public Optional<Task> getTaskByTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException();
        }
        return tasks.stream()
                .filter(t -> t.getTitle().equals(title))
                .findFirst();
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(new HashSet<>(users));
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(new ArrayList<>(tasks));
    }
}