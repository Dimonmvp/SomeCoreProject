package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.Teacher;
import com.mvp.SomeProject.models.University;
import lombok.SneakyThrows;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

public class HandlerTest {
    private Student student;
    private University university;
    private Teacher teacher;


    @Before
    public void setUp(){
        student = Handler.createStudent("Dima","Bobryshev","Vitalievich",
                20,4.4f,"rpz-426");
        Set<String> subjects = new HashSet<>();
        subjects.add("Math");
        subjects.add("English");
        subjects.add("Art");
        teacher = Handler.createTeacher("Maria","Ivanova","Pavlovna",46,
                5300.0f,subjects);
        university = new University();
    }

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
    public void createTeacher(){

    }

    @Test
    public void isUniversityContainsStudentTest(){
        Assert.assertTrue(Handler.isUniversityContainStudent(university,student));
    }

    @Test
    public void deductStudentTest() throws StudentException {
        university.getStudents().add(student);
        Handler.deductStudent(university,student);
        Assert.assertTrue(!Handler.isUniversityContainStudent(university,student));
    }


    @Test
    public void enrollStudent() throws StudentException {
        Handler.enrollStudent(university,student);

        Assert.assertTrue(Handler.isUniversityContainStudent(university,student));
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



}
