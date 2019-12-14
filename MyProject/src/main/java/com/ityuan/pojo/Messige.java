package com.ityuan.pojo;

public class Messige {
    private int mid;
    private String username;
    private String phone;
    private String suggest;

    public Messige() {
    }

    public Messige(int mid, String username, String phone, String suggest) {
        this.mid = mid;
        this.username = username;
        this.phone = phone;
        this.suggest = suggest;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Override
    public String toString() {
        return "Messige{" +
                "mid=" + mid +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", suggest='" + suggest + '\'' +
                '}';
    }
}

