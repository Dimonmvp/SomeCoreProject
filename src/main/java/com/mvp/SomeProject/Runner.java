package com.mvp.SomeProject;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.handlers.*;
import com.mvp.SomeProject.models.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static String name = "[a-zA-Z]";

    public static void main(String[] args) throws StudentException {
        University university = new University();
        Scanner scanner = new Scanner(System.in);
        Student student = StudentHandler.createStudent("Dima","Bobryshev","Vitalievich",
                20,5f,"rpz-426");
        Student student1 = StudentHandler.createStudent("Dima","Bobryshev","Vitalievich",
                22,3.1f,"rpz-426");
        student1 = student;
        System.out.println(student == student1);

    }
}
