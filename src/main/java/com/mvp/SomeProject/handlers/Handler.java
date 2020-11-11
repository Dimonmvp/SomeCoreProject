package com.mvp.SomeProject.handlers;

import com.mvp.SomeProject.exceptions.StudentException;
import com.mvp.SomeProject.exceptions.TeacherException;
import com.mvp.SomeProject.models.Human;
import com.mvp.SomeProject.models.Student;
import com.mvp.SomeProject.models.Teacher;
import com.mvp.SomeProject.models.University;

import java.util.Scanner;
import java.util.Set;

public class Handler {

    /**
     * This regular expression checks only correct enter letters and word is size from 2 to 50
     **/
    protected static final String forWord = "([a-zA-Z]+){2,50}$";

    protected static final String forLetters = "([a-zA-Z]+){2,50}";

    /**
     * This regular expression checks only correct enter numbers of Integer from 10 to 60
     **/
    protected static final String forIntegerNumbers = "[2-9]{1}[0-9]{1}$";

    protected static final String forMark = "[2-5]{1}$";

    protected static final String forCount = "([1-9][0-9]*){1,50}$";

    protected static final String forFloatNumbers = "[2-5](\\.[0-9]+)$";

    protected static final String forSalary = "[1-9]{1}[0-9]{2,9}(\\.[0-9]+)$";

    protected static final String forGroup = "[a-zA-Z]{2,5}(\\-[1-9]{3})$";

    //    protected static final String forDate = "(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[012])\\-\\d{4}$";
    protected static final String forDate = "(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[012])\\-(20{1}[2-9]{1}[0-9]{1})$";

    protected static Scanner scanner = new Scanner(System.in);

    protected static String readCorrect(String stringOfMessage, String regExp, Boolean flag) {
        if (flag) {
            System.out.print("Enter the " + stringOfMessage);
        } else {
            System.out.print("Enter the correct " + stringOfMessage);
        }
        while (!scanner.hasNext(regExp)) {
            System.out.print("Enter the correct " + stringOfMessage);
            scanner.nextLine();
        }
        return scanner.nextLine();
    }


    public static String createName(Human human) {
        return createStr(human.getSurname(), human.getName(), human.getPatronymic());
    }

    public static String createStr(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString();

    }

}
