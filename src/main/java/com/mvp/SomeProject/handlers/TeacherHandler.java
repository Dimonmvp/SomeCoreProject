package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.TeacherException;
import com.mvp.SomeProject.models.Teacher;
import com.mvp.SomeProject.models.University;

import java.util.Set;

public class TeacherHandler extends Handler{
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
