package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.exceptions.TeacherException;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.Teacher;
import com.mvp.SomeProject.models.University;

import java.util.ArrayList;
import java.util.List;

public class UniversityHandler extends Handler {

    public static void createUniversity() {
        University university = new University();
        university.setName(
                readCorrect("name of the University:", forLetters, true));
        university.setRate(
                Float.parseFloat(
                        readCorrect("rate of the University:", forFloatNumbers, true)));
        university.setRate(Float.parseFloat(
                readCorrect(
                        "rate of the University:", forFloatNumbers, true)));
        university.setDirectionOfStudy(createDirectionOfStudy());
    }

    public static List<String> createDirectionOfStudy(){
        List<String> directions = new ArrayList<>();
        int i = Integer.parseInt(readCorrect("count direction of study:", forCount, true));
        while (i>0)
        {
            directions.add(readCorrect("direction of study:",forLetters,true));
            i--;
        }
        return directions;
    }

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
    public static void enrollStudent(University university) throws StudentException {
        Student student = StudentHandler.createStudent();
        if (!isUniversityContainStudent(university,student)) {
            university.getStudents().add(student);
            university.setCountOfStudents(university.getCountOfStudents() + 1);
        } else {
            throw new StudentException("The University has already have this student");
        }
    }

    public static void hireTeacher(University university, Teacher teacher) throws TeacherException {
        if (!isTeacherWorksAtTheUniversity(university,teacher)){
            university.getTeachers().add(teacher);
        }
        else {
            throw new TeacherException("Teacher has already worked at the University");
        }
    }

    public static void fireTeacher(University university,Teacher teacher) throws TeacherException {
        if (isTeacherWorksAtTheUniversity(university,teacher)){
            university.getTeachers().remove(teacher);
        }
        else {
            throw new TeacherException("Teacher isn`t working at the University");
        }
    }

    public static boolean isTeacherWorksAtTheUniversity(University university,Teacher teacher){
        return university.getTeachers().contains(teacher);
    }
}
