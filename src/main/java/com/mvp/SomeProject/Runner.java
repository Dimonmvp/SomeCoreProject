package com.mvp.SomeProject;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.handlers.Handler;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.University;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static String name = "[a-zA-Z]";
    public static void main(String[] args) throws StudentException {
        Student student = new Student();
        student.setName("Dima");
        student.setPatronymic("Vitalievich");
        student.setSurname("BObryshev");
        student.setAge(20);

        Handler.createTeacher();

        University university = new University();
        university.setName("KHPI");
        Handler.enrollStudent(university,student);

//        Pattern compile = Pattern.compile(name);
//        Matcher matcher = compile.matcher("1Di");
//        boolean b = matcher.matches();
        Handler.createStudent();
        Handler.deductStudent(university,student);
    }
}
