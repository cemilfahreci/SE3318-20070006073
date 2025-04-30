package org.example;

import java.util.*;

public class NotificationService {
    private final Map<String, List<String>> inbox = new HashMap<>();

    public void sendNotification(User user, String message) {
        if (user == null || message == null) {
            throw new IllegalArgumentException();
        }
        inbox.computeIfAbsent(user.getUsername(), k -> new ArrayList<>()).add(message);
    }

    public List<String> getNotifications(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }
        return Collections.unmodifiableList(
                inbox.getOrDefault(user.getUsername(), Collections.emptyList())
        );
    }
}