package com.mvp.SomeProject;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.handlers.Handler;
import com.mvp.SomeProject.handlers.MarkRecordBookHandler;
import com.mvp.SomeProject.handlers.StudentHandler;
import com.mvp.SomeProject.handlers.TeacherHandler;
import com.mvp.SomeProject.models.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static String name = "[a-zA-Z]";

    public static void main(String[] args) throws StudentException {
        University university = new University();
        Scanner scanner = new Scanner(System.in);
        university.setName("KHPI");
        Calendar date = new GregorianCalendar();
//        String st = scanner.nextLine();
//        Pattern pattern = Pattern.compile("");
//        Matcher matcher = pattern.matcher(st);
//        System.out.println(matcher.find());
        Set<String > stringSet = new HashSet<>();
        stringSet.add("Math");
        Teacher teacher = TeacherHandler.createTeacher();
//        Student student = StudentHandler.createStudent();
//        RecordBook recordBook = MarkRecordBookHandler.createRecordBook(student);
        Mark mark = MarkRecordBookHandler.createMark(teacher);
        System.out.println(mark.toString());
//        MarkRecordBookHandler.addMarkToRecordBook(recordBook,mark);
//        student.setRecordBook(recordBook);
//        System.out.println(student.toString());
/**
  Пофиксить дату 12 месяца
 **/

        date.set(Calendar.YEAR,2020);
        date.set(Calendar.MONTH,11);
        date.set(Calendar.DAY_OF_MONTH,2);
        System.out.println(date.get(Calendar.YEAR));
        System.out.println(date.get(Calendar.MONTH));
        System.out.println(date.get(Calendar.DAY_OF_MONTH));
//        Pattern compile = Pattern.compile(name);
//        Matcher matcher = compile.matcher("1Di");
//        boolean b = matcher.matches();
    }
}
