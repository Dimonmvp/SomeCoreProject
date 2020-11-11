package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.TeacherException;
import com.mvp.SomeProject.models.University;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TeacherHandlerTest extends HandlerTest {
    @Test
    public void createTeacher(){

    }

    @Test
    public void createTeacherTest(){
        Assert.assertEquals("Maria",teacher.getName());
        Assert.assertEquals("Ivanova",teacher.getSurname());
        Assert.assertEquals("Pavlovna",teacher.getPatronymic());
        Assert.assertEquals(46,(int)teacher.getAge());
        Assert.assertEquals(5300.0f,teacher.getSalary(),0.0);
        Set<String> sbjs = new HashSet<>();
        sbjs.add("Math");
        sbjs.add("English");
        sbjs.add("Art");
        Assert.assertEquals(sbjs,teacher.getSubject());
    }

    @Test
    public void hireTeacherTest() throws TeacherException {
        UniversityHandler.hireTeacher(university,teacher);
        Assert.assertTrue(university.getTeachers().contains(teacher));
    }

    @Test
    public void fireTeacherTest() throws TeacherException {
        UniversityHandler.hireTeacher(university,teacher);
        UniversityHandler.fireTeacher(university,teacher);
        Assert.assertFalse(university.getTeachers().contains(teacher));
    }

    @Test
    public void isTeacherWorksAtTheUniversityTest(){
        Assert.assertFalse(UniversityHandler.isTeacherWorksAtTheUniversity(university,teacher));
    }
}
