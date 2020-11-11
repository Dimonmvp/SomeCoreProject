package com.mvp.SomeProject.models;

import com.mvp.SomeProject.handlers.Handler;
import lombok.Data;

import java.util.Objects;

@Data
public class Student extends Human {
    private String group;
    private Integer course;
    private Float scholarship;
    private Boolean deptOfStudy;
    private Float rate;
    private RecordBook recordBook;


    public Student() {
    }

    public Student(String surname, String name, String patronymic, Integer age,
                   String group, Float rate) {
        super(surname, name, patronymic, age);
        this.group = group;
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return super.equals(o);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return Handler.createStr(
                "Full name", getSurname(), getName(), getPatronymic(), "\n",
                "Group:", group, "\n",
                "Course:", String.valueOf(course), "\n",
                "Scholarship:", String.valueOf(scholarship), "\n",
                "DebtOfStudy", String.valueOf(deptOfStudy), "\n",
                "Rate:", String.valueOf(rate), "\n",
                recordBook.toString()
        );
    }
}
