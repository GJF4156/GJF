package com.ityuan.pojo;

public class Address {
    private int aid;
    private String consignee;
    private String cphone;
    private String content;
    private int createuid;
    public Address() {
    }

    public Address(int aid, String consignee, String cphone, String content, int createuid) {
        this.aid = aid;
        this.consignee = consignee;
        this.cphone = cphone;
        this.content = content;
        this.createuid = createuid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreateuid() {
        return createuid;
    }

    public void setCreateuid(int createuid) {
        this.createuid = createuid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", consignee='" + consignee + '\'' +
                ", cphone='" + cphone + '\'' +
                ", content='" + content + '\'' +
                ", createuid=" + createuid +
                '}';
    }
}
