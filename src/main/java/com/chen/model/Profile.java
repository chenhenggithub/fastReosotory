package com.chen.model;

public class Profile {
    private String username;

    private String langpref;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private String catid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLangpref() {
        return langpref;
    }

    public void setLangpref(String langpref) {
        this.langpref = langpref == null ? null : langpref.trim();
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid == null ? null : catid.trim();
    }
}