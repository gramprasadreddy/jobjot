package com.ram.jobjot.jobjot.entity;

public class JobRecommendation {
    private String title;
    private String description;
    private String redirectUrl;
    private double relevanceScore;

    public JobRecommendation(String title, String description, String redirectUrl, double relevanceScore) {
        this.title = title;
        this.description = description;
        this.redirectUrl = redirectUrl;
        this.relevanceScore = relevanceScore;
    }

    public String getDescription() {
        return description;
    }

    public double getRelevanceScore() {
        return relevanceScore;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRelevanceScore(double relevanceScore) {
        this.relevanceScore = relevanceScore;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

