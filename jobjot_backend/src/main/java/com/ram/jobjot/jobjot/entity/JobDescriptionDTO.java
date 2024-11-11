package com.ram.jobjot.jobjot.entity;

public class JobDescriptionDTO {
    private String title;
    private String description;

    public JobDescriptionDTO() {}

    public JobDescriptionDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
