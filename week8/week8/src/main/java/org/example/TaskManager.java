package org.example;

import java.util.List;

public class TaskManager {
    private final NotificationService notificationService;

    public TaskManager(NotificationService notificationService) {
        if (notificationService == null) {
            throw new IllegalArgumentException();
        }
        this.notificationService = notificationService;
    }

    public void assignTask(User user, Task task) {
        if (user == null || task == null || user.hasTask(task)) {
            throw new IllegalArgumentException();
        }
        user.addTask(task);
        notificationService.sendNotification(user, "New task assigned: " + task.getTitle());
    }

    public void removeTask(User user, Task task) {
        if (user == null || task == null || !user.hasTask(task)) {
            throw new IllegalArgumentException();
        }
        user.removeTask(task);
    }

    public List<Task> listTasks(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }
        return user.getTasks();
    }
}