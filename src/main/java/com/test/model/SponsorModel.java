package com.test.model;

import lombok.Data;

@Data
public class SponsorModel {
    private String id;
    private String name;
    private boolean isDeleted;

    public SponsorModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
