package com.mvp.SomeProject.models;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class Mark {
    private Calendar date;
    private Integer mark;
    private String  teacherName;
    private String subject;

    public Mark() {
    }

    public Mark(Calendar date, Integer mark, String teacher, String subject) {
        this.date = date;
        this.mark = mark;
        this.teacherName = teacher;
        this.subject = subject;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Mark:");
        sb.append("Day:").append((date.get(Calendar.DAY_OF_MONTH))).append("\n");
        sb.append("Moth:").append((date.get(Calendar.MONTH))+1).append("\n");
        sb.append("Year:").append((date.get(Calendar.YEAR))).append("\n");
        sb.append("Mark:").append(mark).append("\n");
        sb.append("Teacher name:").append(teacherName).append("\n");
        sb.append("Subject:").append(subject).append("\n");
        return sb.toString();
    }
}
