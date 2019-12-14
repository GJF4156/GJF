package com.ityuan.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class News {
    private int nid;
    private String title;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date date;

    public News() {
    }

    public News(int nid, String title, String content, Date date) {
        this.nid = nid;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
