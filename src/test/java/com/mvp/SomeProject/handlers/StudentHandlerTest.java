package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import org.junit.Assert;
import org.junit.Test;

public class StudentHandlerTest extends HandlerTest{
    @Test
    public void createStudentTest(){
        Assert.assertEquals("Dima", student.getName());
        Assert.assertEquals("Bobryshev", student.getSurname());
        Assert.assertEquals("Vitalievich", student.getPatronymic());
        Assert.assertEquals(20, (int) student.getAge());
        Assert.assertEquals(4.4f, student.getRate(), 0.0);
        Assert.assertEquals("rpz-426", student.getGroup());
    }

    @Test
    public void isUniversityContainsStudentTest(){
        Assert.assertTrue(StudentHandler.isUniversityContainStudent(university,student));
    }

    @Test
    public void deductStudentTest() throws StudentException {
        university.getStudents().add(student);
        StudentHandler.deductStudent(university,student);
        Assert.assertFalse(StudentHandler.isUniversityContainStudent(university, student));
    }


    @Test
    public void enrollStudent() throws StudentException {
        StudentHandler.enrollStudent(university,student);

        Assert.assertTrue(StudentHandler.isUniversityContainStudent(university,student));
    }
}
