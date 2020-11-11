package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.University;

public class StudentHandler extends Handler {

    public static Student createStudent() {
        Student student = new Student();
        float a;
        student.setName(readCorrect("name of the student:", forWord, true));
        student.setSurname(readCorrect("surname of the student:", forWord, true));
        student.setPatronymic(readCorrect("patronymic of the student:", forWord, true));
        student.setAge(Integer.parseInt(readCorrect("age of the student:", forIntegerNumbers, true)));
        boolean flag = true;
        do {
            a = Float.parseFloat(readCorrect("rate of the student:", forFloatNumbers, flag));
            flag = false;
        } while (a > 5);
        student.setRate(a);
        student.setGroup(readCorrect("group of the student:", forGroup, true));
        return student;
    }

    public static Student createStudent(String name, String surname, String patronymic,
                                        Integer age, Float rate, String group) {
        return new Student(surname, name, patronymic, age, group, rate);
    }

    public static void setScholarShipToStudent(Student student) {
        if (!student.getDeptOfStudy()) {
            student.setScholarship(1700.0f);
        } else {
            System.out.println(Handler.createStr(
                    student.getSurname(),
                    student.getName(),
                    student.getPatronymic(), "has debt of study."));
        }
    }
}
