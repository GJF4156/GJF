package com.demo.pojo;

public class GarBage {
    private String gname;//名字
    private int gtype;//类型 0为可回收、1为有害、2为厨余(湿)、3为其他(干)
    private int aipre;//智能预判，0为正常结果，1为预判结果
    private String explain;//分类解释
    private String contain;//包含类型
    private String tip;//投放提示

    public GarBage() {
    }

    public GarBage(String gname, int gtype, int aipre, String explain, String contain, String tip) {
        this.gname = gname;
        this.gtype = gtype;
        this.aipre = aipre;
        this.explain = explain;
        this.contain = contain;
        this.tip = tip;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getGtype() {
        return gtype;
    }

    public void setGtype(int gtype) {
        this.gtype = gtype;
    }

    public int getAipre() {
        return aipre;
    }

    public void setAipre(int aipre) {
        this.aipre = aipre;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "GarBage{" +
                "gname='" + gname + '\'' +
                ", gtype=" + gtype +
                ", aipre=" + aipre +
                ", explain='" + explain + '\'' +
                ", contain='" + contain + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }
}
