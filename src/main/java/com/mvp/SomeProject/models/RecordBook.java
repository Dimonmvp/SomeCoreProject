package com.mvp.SomeProject.models;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Data
public class RecordBook{
    private List<Mark> marks = new LinkedList<>();
    private String student;

    public RecordBook() {
    }

    public RecordBook(List<Mark> marks, String student) {
        this.marks = marks;
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecordBook)) return false;
        RecordBook that = (RecordBook) o;
        return Objects.equals(getMarks(), that.getMarks()) &&
                Objects.equals(getStudent(), that.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMarks(), getStudent());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Record book\n");
        for (Mark mark :
                marks) {
            sb.append(marks.toString()).append("\n");
        }
        return sb.toString();
    }
}
