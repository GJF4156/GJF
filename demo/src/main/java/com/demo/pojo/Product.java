package com.demo.pojo;

public class Product {

    private int pid;//商品id
    private String description;//商品描述
    private float price;//商品价格
    private int number;//商品库存总量
    private int sold;//商品已售数量

    public Product() {
    }

    public Product(int pid, String description, float price, int number, int sold) {
        this.pid = pid;
        this.description = description;
        this.price = price;
        this.number = number;
        this.sold = sold;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", sold=" + sold +
                '}';
    }
}
