package com.item.testproject2.beans;

import java.util.Date;

public class KePu {
    private String articleTitle;
    private String articleContent;
    private Date articleDate;
    private int articleImage;

    public KePu() {
    }

    public KePu(String articleTitle, String articleContent, Date articleDate, int articleImage) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articleImage = articleImage;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public int getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(int articleImage) {
        this.articleImage = articleImage;
    }
}
