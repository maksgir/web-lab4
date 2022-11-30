package com.maksgir.webbackend.exception;

public class AlreadyExistUserException extends RuntimeException{
    public AlreadyExistUserException(String message) {
        super(message);
    }
}
