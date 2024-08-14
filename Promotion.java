package org.StudentPortail;

import java.util.List;

public class Promotion {
    private String id;
    private String name;
    private List<Student> students;
    private University university;
    public Promotion(String id, String name, List<Student> students, University university) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.university = university;

    }

}
