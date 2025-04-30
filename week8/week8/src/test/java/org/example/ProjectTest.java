package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    @Test
    void addAndGetTask() {
        Project p = new Project();
        Task t = new Task("P", LocalDate.now());
        p.addTask(t);
        Optional<Task> found = p.getTaskByTitle("P");
        assertTrue(found.isPresent());
        assertEquals(t, found.get());
    }

    @Test
    void getTaskEmpty() {
        Project p = new Project();
        Optional<Task> opt = p.getTaskByTitle("No");
        assertFalse(opt.isPresent());
    }

    @Test
    void rejectInvalidAddUserAndTask() {
        Project p = new Project();
        assertThrows(IllegalArgumentException.class, () -> p.addUser(null));
        assertThrows(IllegalArgumentException.class, () -> p.addTask(null));
    }
}