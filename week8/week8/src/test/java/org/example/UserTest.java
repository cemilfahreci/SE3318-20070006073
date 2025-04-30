package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void addAndHasTaskNormal() {
        User u = new User("u1", "e@x.com");
        Task t = new Task("T", LocalDate.now());
        u.addTask(t);
        assertTrue(u.hasTask(t));
    }

    @Test
    void getTasksImmutable() {
        User u = new User("u2", "e2@x.com");
        Task t1 = new Task("X", LocalDate.now());
        u.addTask(t1);
        List<Task> list = u.getTasks();
        assertEquals(1, list.size());
        assertThrows(UnsupportedOperationException.class, () -> list.add(t1));
    }

    @Test
    void removeTaskNormal() {
        User u = new User("u4", "e4@x.com");
        Task t = new Task("R", LocalDate.now());
        u.addTask(t);
        u.removeTask(t);
        assertFalse(u.hasTask(t));
    }

    @Test
    void rejectInvalidAddHasRemove() {
        User u = new User("u3", "e3@x.com");
        assertThrows(IllegalArgumentException.class, () -> u.addTask(null));
        Task t = new Task("Z", LocalDate.now());
        u.addTask(t);
        assertThrows(IllegalArgumentException.class, () -> u.addTask(t));
        assertThrows(IllegalArgumentException.class, () -> u.hasTask(null));
        assertThrows(IllegalArgumentException.class, () -> u.removeTask(null));
        assertThrows(IllegalArgumentException.class, () -> u.removeTask(new Task("X", LocalDate.now())));
    }

    @Test
    void constructorRejectsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, "e"));
        assertThrows(IllegalArgumentException.class, () -> new User("", "e"));
        assertThrows(IllegalArgumentException.class, () -> new User("u", null));
    }
}