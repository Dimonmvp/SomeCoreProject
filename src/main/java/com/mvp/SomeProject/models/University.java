package com.mvp.SomeProject.models;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;


@Data
public class University {
    private String name;
    private Float rate;
    private Integer countOfStudents = 0;
    private List<String> directionOfStudy;
    private List<Student> Students = new LinkedList<>();
    private List<Teacher> teachers = new LinkedList<>();

    public University() {
    }

    public University(String name, Float rate, Integer countOfStudents,
                      List<String> directionOfStudy, List<Student> students, List<Teacher> teachers) {
        this.name = name;
        this.rate = rate;
        this.countOfStudents = countOfStudents;
        this.directionOfStudy = directionOfStudy;
        Students = students;
        this.teachers = teachers;
    }
}
