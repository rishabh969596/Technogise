package com.technogise.exception;

public class BookOutOfBoundException extends RuntimeException {
    private String msg;

    public BookOutOfBoundException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
