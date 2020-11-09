package com.mvp.SomeProject.exceptions;

public class TeacherException extends Exception{
    public TeacherException() {
        super();
    }

    public TeacherException(String message) {
        super(message);
    }

    public TeacherException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeacherException(Throwable cause) {
        super(cause);
    }

    protected TeacherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
