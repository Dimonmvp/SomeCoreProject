package com.mvp.SomeProject.models;

import lombok.Data;

import java.util.Objects;

@Data
public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private Integer age;

    public Human() {
    }

    public Human(String surname, String name, String patronymic, Integer age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getSurname().equals(human.getSurname()) &&
                getName().equals(human.getName()) &&
                getPatronymic().equals(human.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getPatronymic());
    }
}
