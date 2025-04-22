package org.example;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class MagicClassroomTest {
    private MagicClassroom classroom;
    private HogwartsStudent harry, draco;

    @Before
    public void setup() {
        classroom = new MagicClassroom();
        harry = new HogwartsStudent("Harry", "Gryffindor", 5);
        draco = new HogwartsStudent("Draco", "Slytherin", 5);
    }

    @Test
    public void testAddValidStudent() {
        classroom.addStudent(harry);
        assertEquals(harry, classroom.findStudent("Harry"));
    }

    @Test
    public void testAddNullStudent() {
        classroom.addStudent(null);
        assertTrue(classroom.getStudentsSortedByHouse().isEmpty());
    }

    @Test
    public void testFindByNameAndBySpell() {
        harry.learnSpell("Expelliarmus");
        classroom.addStudent(harry);
        assertEquals(harry, classroom.findStudent("Harry"));
        assertEquals(harry, classroom.findStudentBySpell("Expelliarmus"));
        assertNull(classroom.findStudent(null));
        assertNull(classroom.findStudentBySpell(null));
    }

    @Test
    public void testListByHouseAndSorting() {
        HogwartsStudent luna = new HogwartsStudent("Luna", "Ravenclaw", 5);
        classroom.addStudent(harry);
        classroom.addStudent(draco);
        classroom.addStudent(luna);
        List<HogwartsStudent> gryff = classroom.getStudentsByHouse("Gryffindor");
        assertEquals(1, gryff.size());
        List<HogwartsStudent> sorted = classroom.getStudentsSortedByHouse();
        assertEquals(Arrays.asList(harry, luna, draco), sorted);
    }
}