package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.models.Student;
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
        Student student1 = StudentHandler.createStudent("Dima","Bobryshev","Vitalievich",
                22,3.1f,"rpz-426");
        university.getStudents().add(student);

        Assert.assertTrue(UniversityHandler.isUniversityContainStudent(university,student1));
    }

    @Test
    public void deductStudentTest() throws StudentException {
        university.getStudents().add(student);
        UniversityHandler.deductStudent(university,student);
        Assert.assertFalse(UniversityHandler.isUniversityContainStudent(university, student));
    }


    @Test
    public void enrollStudent() throws StudentException {
        UniversityHandler.enrollStudent(university,student);

        Assert.assertTrue(UniversityHandler.isUniversityContainStudent(university,student));
    }
}
