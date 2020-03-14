package com.demo.pojo;

public class ImagesPath {

    private int imgId;
    private int pid;
    private String imgPath;

    public ImagesPath() {
    }

    public ImagesPath(int imgId, int pid, String imgPath) {
        this.imgId = imgId;
        this.pid = pid;
        this.imgPath = imgPath;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "ImagesPath{" +
                "imgId=" + imgId +
                ", pid=" + pid +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
