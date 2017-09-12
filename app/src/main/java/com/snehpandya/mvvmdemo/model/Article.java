package com.snehpandya.mvvmdemo.model;

/**
 * Created by Sneh on 12-09-2017.
 */

public class Article {

    private String title;
    private int commentsNumber;
    private boolean read;

    public Article(String title, int commentsNumber, boolean read) {
        this.title = title;
        this.commentsNumber = commentsNumber;
        this.read = read;
    }

    public String getTitle() {
        return title;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public boolean isRead() {
        return read;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCommentsNumber(int commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
