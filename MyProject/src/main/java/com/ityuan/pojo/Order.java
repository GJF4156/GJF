package com.ityuan.pojo;

public class Order {
    private int oid;//订单号
    private int uid;//发布人uid
    private String username;//发布人
    private String colId;//任务类型
    private String describe;//任务描述
    private String address;//收货地址
    private String other_requirements;//其他要求
    private Float cost;//赏金
    private String order_state;//订单状态(0:未处理 1:已处理 2:进行中)
    private String release_date;//发布时间
    private String expect_time;//期望完成时间
    private int receipt;//接单人

    public Order() {
    }

    public Order(int oid, int uid, String username, String colId, String describe, String address, String other_requirements, Float cost, String order_state, String release_date, String expect_time, int receipt) {
        this.oid = oid;
        this.uid = uid;
        this.username = username;
        this.colId = colId;
        this.describe = describe;
        this.address = address;
        this.other_requirements = other_requirements;
        this.cost = cost;
        this.order_state = order_state;
        this.release_date = release_date;
        this.expect_time = expect_time;
        this.receipt = receipt;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    public String getColId() {
        return colId;
    }

    public void setColId(String colId) {
        this.colId = colId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOther_requirements() {
        return other_requirements;
    }

    public void setOther_requirements(String other_requirements) {
        this.other_requirements = other_requirements;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getExpect_time() {
        return expect_time;
    }

    public void setExpect_time(String expect_time) {
        this.expect_time = expect_time;
    }

    public int getReceipt() {
        return receipt;
    }

    public void setReceipt(int receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", colId='" + colId + '\'' +
                ", describe='" + describe + '\'' +
                ", address='" + address + '\'' +
                ", other_requirements='" + other_requirements + '\'' +
                ", cost=" + cost +
                ", order_state='" + order_state + '\'' +
                ", release_date='" + release_date + '\'' +
                ", expect_time='" + expect_time + '\'' +
                ", receipt=" + receipt +
                '}';
    }
}
