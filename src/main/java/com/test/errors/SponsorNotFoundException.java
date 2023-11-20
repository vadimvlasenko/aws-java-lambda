package com.test.errors;

public class SponsorNotFoundException extends RuntimeException {

    public SponsorNotFoundException() {
    }

    public SponsorNotFoundException(String message) {
        super("Cannot find sponsor with the provided ID");
    }

    public SponsorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
