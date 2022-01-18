package com.spacex.data.structure.stack.exception;

public class StackOverFlowException extends RuntimeException {
    public StackOverFlowException() {
    }

    public StackOverFlowException(String message) {
        super(message);
    }

    public StackOverFlowException(String message, Throwable cause) {
        super(message, cause);
    }
}
