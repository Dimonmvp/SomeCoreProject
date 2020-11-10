package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.University;

public class StudentHandler extends Handler{
    public static void deductStudent(University university, Student student) throws StudentException {
        if (isUniversityContainStudent(university,student)) {
            university.getStudents().remove(student);
            university.setCountOfStudents(university.getCountOfStudents() - 1);
        }
        else {
            throw new StudentException("Student isn`t studying at the University");
        }
    }

    public static boolean isUniversityContainStudent(University university,Student student){
        return university.getStudents().contains(student);
    }

    public static void enrollStudent(University university, Student student) throws StudentException {
        if (!isUniversityContainStudent(university,student)) {
            university.getStudents().add(student);
            university.setCountOfStudents(university.getCountOfStudents() + 1);
        } else {
            throw new StudentException("The University has already have this student");
        }
    }

    public static Student createStudent() {
        Student student = new Student();
        float a;
        student.setName(readCorrect("name of the student:",forLetters,true));
        student.setSurname(readCorrect("surname of the student:",forLetters,true));
        student.setPatronymic(readCorrect("patronymic of the student:",forLetters,true));
        student.setAge(Integer.parseInt(readCorrect("age of the student:",forIntegerNumbers,true)));
        boolean flag = true;
        do{
            a = Float.parseFloat(readCorrect("rate of the student:",forFloatNumbers,flag));
            flag = false;
        }while (a>5);
        student.setRate(a);
        student.setGroup(readCorrect("group of the student:",forGroup,true));
        return student;
    }

    public static Student createStudent(String name,String surname,String patronymic,
                                        Integer age,Float rate,String group) {
        return new Student(surname,name,patronymic,age,group,rate);
    }

}
