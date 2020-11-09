package com.mvp.SomeProject.models;

import lombok.Data;

import java.util.Objects;

@Data
public class Student extends Human{
    private String group;
    private Integer course;
    private Float Scholarship;
    private Boolean deptOfStudy;
    private Float rate;


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
        return Objects.equals(getGroup(), student.getGroup()) &&
                Objects.equals(getRate(), student.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGroup(), getRate());
    }
}
