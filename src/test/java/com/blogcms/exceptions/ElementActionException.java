package com.blogcms.exceptions;

public class ElementActionException extends RuntimeException {
    public ElementActionException(String message) {
        super(message);
    }

    public ElementActionException(String message, Throwable cause) {
        super(message, cause);
    }
} 