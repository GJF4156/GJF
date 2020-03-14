package com.demo.pojo;

public class Orders {
    private String oid;//订单编号
    private int pid;//商品id
    private int productNum;//商品数量
    private float amount;//总金额
    private String uid;//下单用户
    private int aid;//收货地址
    private String status;//订单状态
    private String payStatus;//支付状态
    private String shipTime;//发货时间
    private String createTime;//创建时间
    private String payTime;//支付时间

    public Orders() {
    }

    public Orders(String oid, int pid, int productNum, float amount, String uid,
                  int aid, String status, String payStatus,
                  String shipTime, String createTime, String payTime) {
        this.oid = oid;
        this.pid = pid;
        this.productNum = productNum;
        this.amount = amount;
        this.uid = uid;
        this.aid = aid;
        this.status = status;
        this.payStatus = payStatus;
        this.shipTime = shipTime;
        this.createTime = createTime;
        this.payTime = payTime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getShipTime() {
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", pid=" + pid +
                ", productNum=" + productNum +
                ", amount=" + amount +
                ", uid='" + uid + '\'' +
                ", aid=" + aid +
                ", status='" + status + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", shipTime='" + shipTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", payTime='" + payTime + '\'' +
                '}';
    }
}
