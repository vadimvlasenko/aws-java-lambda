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

    // Update the constructor to handle deleted sponsors
    public SponsorNotFoundException(String sponsorId) {
        super(String.format("Sponsor with id '%s' not found or has been deleted", sponsorId));
    }
}
