package com.mvp.SomeProject.models;

import com.mvp.SomeProject.handlers.Handler;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Data
public class Mark {
    private Calendar date;
    private Integer mark;
    private String teacherName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;
        Mark mark1 = (Mark) o;
        return Objects.equals(getDate(), mark1.getDate()) &&
                Objects.equals(getMark(), mark1.getMark()) &&
                Objects.equals(getTeacherName(), mark1.getTeacherName()) &&
                Objects.equals(getSubject(), mark1.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getMark(), getTeacherName(), getSubject());
    }

    @Override
    public String toString() {
        return Handler.createStr("Mark", "\n",
                "Day:", String.valueOf(date.get(Calendar.DAY_OF_MONTH)), "\n",
                "Moth:", String.valueOf((date.get(Calendar.MONTH)) + 1),"\n",
                "Year:", String.valueOf(date.get(Calendar.YEAR)), "\n",
                "Mark:", String.valueOf(mark), "\n",
                "Teacher name", teacherName, "\n",
                "Subject:", subject,"\n");
    }
}
