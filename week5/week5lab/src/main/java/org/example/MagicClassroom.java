package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MagicClassroom {
    private List<HogwartsStudent> students;

    public MagicClassroom() {
        students = new ArrayList<>();
    }

    public void addStudent(HogwartsStudent student) {
        if (student != null)
            students.add(student);
    }

    public HogwartsStudent findStudent(String name) {
        for (HogwartsStudent s : students) {
            if (s.getName().equals(name))
                return s;
        }
        return null;
    }

    public HogwartsStudent findStudentBySpell(String spell) {
        for (HogwartsStudent s : students) {
            if (s.knowsSpell(spell))
                return s;
        }
        return null;
    }

    public List<HogwartsStudent> getStudentsByHouse(String house) {
        List<HogwartsStudent> result = new ArrayList<>();
        for (HogwartsStudent s : students) {
            if (s.getHouse().equals(house))
                result.add(s);
        }
        return result;
    }

    public List<HogwartsStudent> getStudentsSortedByHouse() {
        students.sort(Comparator.comparing(HogwartsStudent::getHouse));
        return students;
    }
}