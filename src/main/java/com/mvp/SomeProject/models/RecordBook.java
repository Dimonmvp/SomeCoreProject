package com.mvp.SomeProject.models;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class RecordBook{
    private List<Mark> marks = new LinkedList<>();
    private String student;

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
