package com.ityuan.pojo;

import java.util.Date;

public class Forum {
    private int fid;//帖子id
    private int publishUid;//发帖人id
    private String content;//帖子内容
    private Date date;//发帖时间

    public Forum() {
    }

    public Forum(int fid, int publishUid, String content, Date date) {
        this.fid = fid;
        this.publishUid = publishUid;
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
        return "Forum{" +
                "fid=" + fid +
                ", publishUid=" + publishUid +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
