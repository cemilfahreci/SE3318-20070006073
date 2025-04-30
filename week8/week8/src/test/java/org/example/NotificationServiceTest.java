package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {
    @Test
    void sendAndRetrieve() {
        NotificationService ns = new NotificationService();
        User u = new User("n1", "n@x.com");
        ns.sendNotification(u, "Hi");
        ns.sendNotification(u, "Again");
        List<String> notes = ns.getNotifications(u);
        assertEquals(2, notes.size());
    }

    @Test
    void emptyWhenNone() {
        NotificationService ns = new NotificationService();
        User u = new User("n2", "n2@x.com");
        assertTrue(ns.getNotifications(u).isEmpty());
    }

    @Test
    void rejectsNulls() {
        NotificationService ns = new NotificationService();
        assertThrows(IllegalArgumentException.class, () -> ns.sendNotification(null, "m"));
        assertThrows(IllegalArgumentException.class, () -> ns.sendNotification(new User("u","e"), null));
        assertThrows(IllegalArgumentException.class, () -> ns.getNotifications(null));
    }
}