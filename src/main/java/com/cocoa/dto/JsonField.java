package com.cocoa.dto;

public class JsonField {
    private String url;
    private String name;
    private String title;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public JsonField(String url, String name, String title) {
        this.url = url;
        this.name = name;
        this.title = title;
    }

}
