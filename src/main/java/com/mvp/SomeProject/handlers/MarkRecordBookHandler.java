package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.models.Mark;
import com.mvp.SomeProject.models.RecordBook;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.Teacher;

import java.util.*;
import java.util.stream.Collectors;

public class MarkRecordBookHandler extends Handler {

    public static Mark createMark(Teacher teacher) {
        Mark mark = null;
        String s = subjectOfTeacher(teacher);
        if (!s.equals("EXIT")) {
            mark = new Mark();
            mark.setSubject(s);
        List<Integer> strings = parseDate(readCorrect("data of the mark:", forDate, true));
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(Calendar.MONTH,strings.get(1)-1);
            gregorianCalendar.set(Calendar.YEAR,strings.get(2));
            gregorianCalendar.set(Calendar.DAY_OF_MONTH,strings.get(0));
            mark.setDate(gregorianCalendar);
        mark.setMark(Integer.parseInt(readCorrect("mark:",forMark,true)));
        mark.setTeacherName(createNameOfTeacher(teacher));
        }
        return mark;
    }

    private static String createNameOfTeacher(Teacher teacher){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(teacher.getSurname());
        stringBuilder.append(" ");
        stringBuilder.append(teacher.getName());
        stringBuilder.append(" ");
        stringBuilder.append(teacher.getPatronymic());
        return stringBuilder.toString();
    }

    public static RecordBook createRecordBook(Student student){
        RecordBook recordBook = new RecordBook();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(student.getSurname());
        stringBuilder.append(" ");
        stringBuilder.append(student.getName());
        stringBuilder.append(" ");
        stringBuilder.append(student.getPatronymic());
        recordBook.setStudent(stringBuilder.toString());
        return recordBook;
    }

    public static void addMarkToRecordBook(RecordBook recordBook,Mark mark){
        recordBook.getMarks().add(mark);
    }

    private static String subjectOfTeacher(Teacher teacher) {
        String s;
        Set<String> subject = teacher.getSubject();
        System.out.println("If you don`t want to add mark from this teacher, you need to enter \"EXIT\"");
        boolean flag = true;
        do {
            s = readCorrect("subject of the teacher that makes assessment:", forLetters, flag);
            flag = false;

        } while (!(subject.contains(s)) && !s.equals("EXIT"));
        return s;
    }

    private static List<Integer> parseDate(String calendar) {
        return Arrays.stream(calendar.split("-")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
