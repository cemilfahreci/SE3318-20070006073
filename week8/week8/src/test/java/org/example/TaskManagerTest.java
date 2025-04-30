package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    @Test
    void assignAndList() {
        NotificationService ns = new NotificationService();
        TaskManager tm = new TaskManager(ns);
        User u = new User("tm1", "t@x.com");
        Task t = new Task("A", LocalDate.now());
        tm.assignTask(u, t);
        List<Task> tasks = tm.listTasks(u);
        assertEquals(1, tasks.size());
        assertEquals(1, ns.getNotifications(u).size());
    }

    @Test
    void removeTaskNormal() {
        NotificationService ns = new NotificationService();
        TaskManager tm = new TaskManager(ns);
        User u = new User("tm2", "t2@x.com");
        Task t = new Task("B", LocalDate.now());
        tm.assignTask(u, t);
        tm.removeTask(u, t);
        assertFalse(tm.listTasks(u).contains(t));
    }

    @Test
    void rejectInvalidAssignRemove() {
        NotificationService ns = new NotificationService();
        TaskManager tm = new TaskManager(ns);
        User u = new User("tm3", "t3@x.com");
        Task t = new Task("C", LocalDate.now());
        assertThrows(IllegalArgumentException.class, () -> tm.assignTask(null, t));
        assertThrows(IllegalArgumentException.class, () -> tm.assignTask(u, null));
        assertThrows(IllegalArgumentException.class, () -> tm.removeTask(u, t));
    }
}