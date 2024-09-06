package org.openfeign.testmultiproject.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
