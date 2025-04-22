package org.example;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import static org.junit.Assert.*;

public class WizardExamTest {
    private WizardExam exam;
    private HogwartsStudent student;

    @Before
    public void setup() {
        exam = new WizardExam(Arrays.asList("Expelliarmus", "Protego"));
        student = new HogwartsStudent("Neville", "Gryffindor", 4);
    }

    @Test
    public void testPassTrue() {
        student.learnSpell("Expelliarmus");
        student.learnSpell("Protego");
        assertTrue(exam.pass(student));
    }

    @Test
    public void testPassFalse() {
        student.learnSpell("Expelliarmus");
        assertFalse(exam.pass(student));
    }

    @Test
    public void testEvaluateOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        exam.evaluate(student);
        String printed = out.toString().trim();
        assertTrue(printed.contains("has failed the exam"));
    }
}