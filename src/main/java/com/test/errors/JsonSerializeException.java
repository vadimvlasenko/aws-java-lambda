package com.test.errors;

public class JsonSerializeException extends RuntimeException {

    public JsonSerializeException() {
    }

    public JsonSerializeException(String message) {
        super(message);
    }

    public JsonSerializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
