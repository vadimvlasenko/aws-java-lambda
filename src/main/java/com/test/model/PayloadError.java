package com.test.model;

import lombok.Data;

@Data
public class PayloadError {
    private String code;
    private String message;
    private String field;

    public PayloadError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public PayloadError(String code, String message, String field) {
        this.code = code;
        this.message = message;
        this.field = field;
    }

}
