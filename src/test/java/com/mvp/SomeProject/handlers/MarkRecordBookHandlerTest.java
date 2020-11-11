package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.models.Mark;
import com.mvp.SomeProject.models.RecordBook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MarkRecordBookHandlerTest extends HandlerTest{

    protected Mark mark;
    protected RecordBook recordBook;
    protected List<Mark> marks;
    protected Calendar calendar;

    @Before
    public void setUpMarkAndRecordBook()
    {
        HandlerTest handlerTest = new HandlerTest();
        handlerTest.setUp();
        calendar = new GregorianCalendar();
        marks = new ArrayList<>();
        calendar.set(Calendar.YEAR,2020);
        calendar.set(Calendar.MONTH,12);
        calendar.set(Calendar.DAY_OF_MONTH,10);
        mark = new Mark(calendar,5,"Maria Ivanova Pavlovna","Math");
        marks.add(mark);
        recordBook = new RecordBook(marks,Handler.createName(student));
    }

    @Test
    public void createRecordBookTest(){
        RecordBook recordBookCreated = MarkRecordBookHandler.createRecordBook(student);
        recordBookCreated.setMarks(marks);
        Assert.assertEquals(recordBook,recordBookCreated);
    }

    @Test
    public void isRecordBookContainMarkTest(){
        Mark privateMark = new Mark(calendar,5,"Maria Ivanova Pavlovna","Math");
        Assert.assertTrue(MarkRecordBookHandler.isRecordBookContainMark(recordBook,privateMark));
    }

    @Test
    public void parseDataTest(){
        ArrayList<Integer> strings = new ArrayList<>();
        strings.add(10);
        strings.add(12);
        strings.add(2020);
        Assert.assertEquals(strings,MarkRecordBookHandler.parseDate("10-12-2020"));
    }

    @Test
    public void addMarkToRecordBookTest(){
        Mark privateMark = new Mark(calendar,5,"Maria Ivanova Pavlovna","Math");
        MarkRecordBookHandler.addMarkToRecordBook(recordBook,privateMark);
        Assert.assertTrue(MarkRecordBookHandler.isRecordBookContainMark(recordBook,privateMark));
    }
}
