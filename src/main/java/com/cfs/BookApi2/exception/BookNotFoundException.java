package com.cfs.BookApi2.exception;

public class BookNotFoundException extends  RuntimeException {

    public BookNotFoundException (String message) {
        super(message);    //super - parent class ko call krna
    }
}
