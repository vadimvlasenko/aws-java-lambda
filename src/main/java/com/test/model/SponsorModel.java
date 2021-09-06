package com.test.model;

import lombok.Data;

@Data
public class SponsorModel {
    private String id;
    private String name;

    public SponsorModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
