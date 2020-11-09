package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.exceptions.TeacherException;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.Teacher;
import com.mvp.SomeProject.models.University;

import java.util.Scanner;
import java.util.Set;

public class Handler {

    /** This regular expression checks only correct enter letters and word is size from 2 to 50 **/
    private static final String forLetters = "([a-zA-Z]+){2,50}$";
    /** This regular expression checks only correct enter numbers of Integer from 10 to 60 **/
    private static final String forIntegerNumbers = "[1-9][0-9]+$";

    private static final String forFloatNumbers = "[2-5](\\.[0-9]+)$";

    private static final String forSalary = "[1-9]{1}[0-9]{2,9}(\\.[0-9]+)$";

    private static final String forGroup = "[a-zA-Z]{2,5}(\\-[1-9]{3})$";

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

    public static Teacher createTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName(
                readCorrect("name of the teacher:",forLetters,true));
        teacher.setSurname(
                readCorrect("surname of the teacher:",forLetters,true));
        teacher.setPatronymic(
                readCorrect("patronymic of the teacher:",forLetters,true));
        teacher.setAge(Integer.parseInt(
                readCorrect("age of the teacher:",forIntegerNumbers,true)));
        teacher.getSubject().add(readCorrect("subject of the teacher", forLetters, true));

        teacher.setSalary(Float.parseFloat(
                readCorrect("salary of the teacher",forSalary,true)));
        return teacher;
    }

    public static Teacher createTeacher(String name, String surname, String patronymic,
                                        Integer age, Float salary, Set<String> subjects){
        return new Teacher(surname,name,patronymic,age,subjects,salary);
    }

    public static void hireTeacher(University university,Teacher teacher) throws TeacherException {
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
        return university.getTeachers().contains(teacher) ? true : false;
    }

    private static String readCorrect(String stringOfMessage,String regExp,Boolean flag) {
        Scanner scanner = new Scanner(System.in);
        if (flag){
            System.out.print("Enter the " + stringOfMessage);
        }
        else {
            System.out.print("Enter the correct " + stringOfMessage);
        }
        while (!scanner.hasNext(regExp)) {
            System.out.print("Enter the correct " + stringOfMessage);
            scanner.nextLine();
        }
        return scanner.nextLine();
    }
}
