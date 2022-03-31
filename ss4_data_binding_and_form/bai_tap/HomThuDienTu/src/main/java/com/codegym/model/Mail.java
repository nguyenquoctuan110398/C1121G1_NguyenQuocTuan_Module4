package com.codegym.model;

public class Mail {
    private String languages;
    private String pageSize;
    private Boolean spams;
    private String signature;

    public Mail() {
    }

    public Mail(String languages, String pageSize, Boolean spams, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpams() {
        return spams;
    }

    public void setSpams(Boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
