package com.ityuan.pojo;

import java.util.List;

public class User {
    private int uid;
    private String username;
    private String phone;
    private String password;
    private String email;
    private List<Address> addressList;
    public User() {
    }

    public User(int uid, String username, String phone, String password, String email, List<Address> addressList) {
        this.uid = uid;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.addressList = addressList;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", addressList=" + addressList +
                '}';
    }
}
