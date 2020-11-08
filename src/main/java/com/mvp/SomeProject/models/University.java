package com.mvp.SomeProject.models;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;


@Data
public class University {
    private String name;
    private Float rate;
    private Integer countOfStudents = 0;
    private List<String> directionOfStudy = new LinkedList<>();
    private List<Student> Students = new LinkedList<>();
    private List<Teacher> teachers = new LinkedList<>();


}
