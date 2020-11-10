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
        return Objects.equals(getGroup(), student.getGroup()) &&
                Objects.equals(getRate(), student.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGroup(), getRate());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Surname:").append(getSurname()).append("\n");
        sb.append("Name:").append(getName()).append("\n");
        sb.append("Patronymic:").append(getPatronymic()).append("\n");
        sb.append("Group:");
        sb.append(group);
        sb.append("\n");
        sb.append("Course:");
        sb.append(course);
        sb.append("\n");
        sb.append("Scholarship:");
        sb.append(Scholarship);
        sb.append("\n");
        sb.append("deptOfStudy:");
        sb.append(deptOfStudy);
        sb.append("\n");
        sb.append("rate:");
        sb.append(rate);
        sb.append("\n");
        sb.append(recordBook.toString());
        sb.append("\n");
        return sb.toString();
    }
}
