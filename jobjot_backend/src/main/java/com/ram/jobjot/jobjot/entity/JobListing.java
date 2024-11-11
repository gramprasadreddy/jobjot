package com.ram.jobjot.jobjot.entity;

public class JobListing {
    private String title;
    private String description;
    private String redirectUrl;
    private double salaryMin;

    public JobListing(String title, String description, String redirectUrl, double salaryMin) {
        this.title = title;
        this.description = description;
        this.redirectUrl = redirectUrl;
        this.salaryMin = salaryMin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getDescription() {
        return description;
    }

}
