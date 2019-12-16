package com.ityuan.pojo;

public class Reply {
    private int rid;//回复id
    private int fid;//被回复的帖子id
    private int uid;//回复人用户名
    private String username;//回复人用户名
    private String content;//回复的内容
    private String replyTime;//回复的时间

    public Reply() {
    }

    public Reply(int rid, int fid, int uid, String username, String content, String replyTime) {
        this.rid = rid;
        this.fid = fid;
        this.uid = uid;
        this.username = username;
        this.content = content;
        this.replyTime = replyTime;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", fid=" + fid +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", replyTime='" + replyTime + '\'' +
                '}';
    }
}
