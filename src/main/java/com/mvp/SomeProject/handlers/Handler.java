package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.University;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Handler {

    /** This regular expression checks only correct enter letters and word is size from 2 to 50 **/
    private static final String forLetters = "([a-zA-Z]+){2,50}$";
    /** This regular expression checks only correct enter numbers of Integer from 10 to 60 **/
    private static final String forIntegerNumbers = "[17-50]+$";

    private static final String forFloatNumbers = "[2-5]{1,5}(\\.[0-9]+)?";

    private static final String forGroup = "[a-zA-Z]{2,5}(\\.[1-9]{3})?";

    public static void deductStudent(University university, Student student) {
        if (university.getStudents().contains(student)) {
            university.getStudents().remove(student);
            university.setCountOfStudents(university.getCountOfStudents() - 1);
        }
    }

    public static void enrollStudent(University university, Student student) throws StudentException {
        if (!university.getStudents().contains(student)) {
            university.getStudents().add(student);
            university.setCountOfStudents(university.getCountOfStudents() + 1);
        } else {
            throw new StudentException("The University has already have this student");
        }
    }

    public static Student createStudent() {
        Student student = new Student();
        float a = 0f;
//        student.setName(readCorrect("name",forLetters,true));
//        student.setSurname(readCorrect("surname",forLetters,true));
//        student.setPatronymic(readCorrect("patronymic",forLetters,true));
        student.setAge(Integer.parseInt(readCorrect("age",forIntegerNumbers,true)));
        boolean flag = true;
        do{
            a = Float.parseFloat(readCorrect("rate",forFloatNumbers,flag));
            flag = false;
        }while (a>5);
        student.setRate(a);
        student.setGroup(readCorrect("group",forGroup,true));
        return student;
    }

    private static String readCorrect(String stringOfMessage,String regExp,Boolean flag) {
        Scanner scanner = new Scanner(System.in);
        if (flag){
            System.out.print("Enter the " + stringOfMessage + " of the student:");
        }
        else {
            System.out.print("Enter the correct " + stringOfMessage + " of the student:");
        }
        while (!scanner.hasNext(regExp)) {
            System.out.print("Enter the correct " + stringOfMessage + " of the student:");
            scanner.nextLine();
        }
        return scanner.nextLine();
    }
}
