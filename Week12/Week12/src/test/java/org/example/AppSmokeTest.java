package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Smoke tests for core methods in ExampleUsage.
 */
public class AppSmokeTest {

    /**
     * Tests sumArray method.
     */
    @Test
    void testSumArray() {
        ExampleUsage eu = new ExampleUsage();
        assertEquals(15, eu.sumArray());
    }
}