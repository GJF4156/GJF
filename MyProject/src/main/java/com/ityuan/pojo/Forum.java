package com.ityuan.pojo;

import java.util.Date;

public class Forum {
    private int fid;//帖子id
    private int publishUid;//发帖人id
    private String publishUser;
    private String content;//帖子内容
    private String date;//发帖时间

    public Forum() {
    }

    public Forum(int fid, int publishUid, String publishUser, String content, String date) {
        this.fid = fid;
        this.publishUid = publishUid;
        this.publishUser = publishUser;
        this.content = content;
        this.date = date;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getPublishUid() {
        return publishUid;
    }

    public void setPublishUid(int publishUid) {
        this.publishUid = publishUid;
    }

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "fid=" + fid +
                ", publishUid=" + publishUid +
                ", publishUser='" + publishUser + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
