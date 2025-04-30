package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void smokeConstructorAndGetters() {
        Task t = new Task("A", LocalDate.now().plusDays(1));
        assertEquals("A", t.getTitle());
        assertFalse(t.isCompleted());
        assertFalse(t.isOverdue());
    }

    @Test
    void isOverdueWhenPast() {
        Task t = new Task("B", LocalDate.now().minusDays(1));
        assertTrue(t.isOverdue());
    }

    @Test
    void markCompletedClearsOverdue() {
        Task t = new Task("C", LocalDate.now().minusDays(5));
        t.markCompleted();
        assertTrue(t.isCompleted());
        assertFalse(t.isOverdue());
    }

    @Test
    void constructorRejectsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, LocalDate.now()));
        assertThrows(IllegalArgumentException.class, () -> new Task("", LocalDate.now()));
        assertThrows(IllegalArgumentException.class, () -> new Task("A", null));
    }
}