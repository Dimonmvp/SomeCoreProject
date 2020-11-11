package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.exceptions.TeacherException;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.Teacher;
import com.mvp.SomeProject.models.University;
import org.junit.*;

import java.util.HashSet;
import java.util.Set;

public class HandlerTest {
    protected Student student;
    protected University university;
    protected Teacher teacher;


    @Before
    public void setUp(){
        student = StudentHandler.createStudent("Dima","Bobryshev","Vitalievich",
                20,5f,"rpz-426");
        Set<String> subjects = new HashSet<>();
        subjects.add("Math");
        subjects.add("English");
        subjects.add("Art");
        teacher = TeacherHandler.createTeacher("Maria","Ivanova","Pavlovna",46,
                5300.0f,subjects);
        university = new University();
    }







}
