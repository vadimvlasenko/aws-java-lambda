package com.test.errors;

public class SponsorNotFoundException extends RuntimeException {

    public SponsorNotFoundException() {
    }

    public SponsorNotFoundException(String message) {
        super(message);
    }

    public SponsorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
