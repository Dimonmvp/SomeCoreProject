package com.mvp.SomeProject.models;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Teacher extends Human{
    private Set<String> subject = new HashSet<>();
    private Float salary;

    public Teacher() {
    }

    public Teacher(Set<String> subject, Float salary) {
        this.subject = subject;
        this.salary = salary;
    }

    public Teacher(String surname, String name, String patronymic, Integer age, Set<String> subject, Float salary) {
        super(surname, name, patronymic, age);
        this.subject = subject;
        this.salary = salary;
    }
}
