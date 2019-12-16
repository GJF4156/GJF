package com.ityuan.pojo;

public class StuCard {
    private int cid;
    private int uid;//认证用户ID
    private String realName;//真实姓名
    private String stuNumber;//学号
    private String cardImage;//学生证照片

    public StuCard() {
    }

    public StuCard(int cid, int uid, String realName, String stuNumber, String cardImage) {
        this.cid = cid;
        this.uid = uid;
        this.realName = realName;
        this.stuNumber = stuNumber;
        this.cardImage = cardImage;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getCardImage() {
        return cardImage;
    }

    public void setCardImage(String cardImage) {
        this.cardImage = cardImage;
    }

    @Override
    public String toString() {
        return "StuCard{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", realName='" + realName + '\'' +
                ", stuNumber='" + stuNumber + '\'' +
                ", cardImage='" + cardImage + '\'' +
                '}';
    }
}
