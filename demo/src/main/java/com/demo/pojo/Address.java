package com.demo.pojo;

public class Address {
    private int aid;
    private String receiver;
    private String phone;
    private String address;
    private String uid;

    public Address() {
    }

    public Address(int aid, String receiver, String phone, String address, String uid) {
        this.aid = aid;
        this.receiver = receiver;
        this.phone = phone;
        this.address = address;
        this.uid = uid;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", receiver='" + receiver + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
