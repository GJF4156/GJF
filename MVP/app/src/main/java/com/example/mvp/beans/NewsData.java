package com.example.mvp.beans;

import java.util.List;

public class NewsData {


    /**
     * code : 200
     * datalist : [{"gname":"眼镜架","gtype":0,"aipre":0,"explain":"可回收垃圾指适宜回收、可循环利用的生活废弃物","contain":"常见包括各类废金属、玻璃瓶、易拉罐、饮料瓶、塑料玩具、书本、报纸、广告单、纸板箱、衣服、床上用品、电子产品等","tip":"轻投轻放；清洁干燥，避免污染，费纸尽量平整；立体包装物请清空内容物，清洁后压扁投放；有尖锐边角的、应包裹后投放"},{"gname":"隐形眼镜包装盒","gtype":0,"aipre":0,"explain":"可回收垃圾指适宜回收、可循环利用的生活废弃物","contain":"常见包括各类废金属、玻璃瓶、易拉罐、饮料瓶、塑料玩具、书本、报纸、广告单、纸板箱、衣服、床上用品、电子产品等","tip":"轻投轻放；清洁干燥，避免污染，费纸尽量平整；立体包装物请清空内容物，清洁后压扁投放；有尖锐边角的、应包裹后投放"},{"gname":"眼镜","gtype":3,"aipre":0,"explain":"干（其他）垃圾即其它垃圾，指除可回收物、有害垃圾、厨余垃圾（湿垃圾）以外的其它生活废弃物。","contain":"常见包括砖瓦陶瓷、渣土、卫生间废纸、猫砂、污损塑料、毛发、硬壳、一次性制品、灰土、瓷器碎片等难以回收的废弃物","tip":"尽量沥干水分；难以辨识类别的生活垃圾都可以投入干垃圾容器内"},{"gname":"隐形眼镜","gtype":3,"aipre":0,"explain":"干（其他）垃圾即其它垃圾，指除可回收物、有害垃圾、厨余垃圾（湿垃圾）以外的其它生活废弃物。","contain":"常见包括砖瓦陶瓷、渣土、卫生间废纸、猫砂、污损塑料、毛发、硬壳、一次性制品、灰土、瓷器碎片等难以回收的废弃物","tip":"尽量沥干水分；难以辨识类别的生活垃圾都可以投入干垃圾容器内"},{"gname":"隐形眼镜护理液","gtype":3,"aipre":0,"explain":"干（其他）垃圾即其它垃圾，指除可回收物、有害垃圾、厨余垃圾（湿垃圾）以外的其它生活废弃物。","contain":"常见包括砖瓦陶瓷、渣土、卫生间废纸、猫砂、污损塑料、毛发、硬壳、一次性制品、灰土、瓷器碎片等难以回收的废弃物","tip":"尽量沥干水分；难以辨识类别的生活垃圾都可以投入干垃圾容器内"},{"gname":"太阳眼镜","gtype":3,"aipre":0,"explain":"干（其他）垃圾即其它垃圾，指除可回收物、有害垃圾、厨余垃圾（湿垃圾）以外的其它生活废弃物。","contain":"常见包括砖瓦陶瓷、渣土、卫生间废纸、猫砂、污损塑料、毛发、硬壳、一次性制品、灰土、瓷器碎片等难以回收的废弃物","tip":"尽量沥干水分；难以辨识类别的生活垃圾都可以投入干垃圾容器内"}]
     * message : success
     */

    private int code;
    private String message;
    private List<DatalistBean> datalist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DatalistBean> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<DatalistBean> datalist) {
        this.datalist = datalist;
    }

    public static class DatalistBean {
        /**
         * gname : 眼镜架
         * gtype : 0
         * aipre : 0
         * explain : 可回收垃圾指适宜回收、可循环利用的生活废弃物
         * contain : 常见包括各类废金属、玻璃瓶、易拉罐、饮料瓶、塑料玩具、书本、报纸、广告单、纸板箱、衣服、床上用品、电子产品等
         * tip : 轻投轻放；清洁干燥，避免污染，费纸尽量平整；立体包装物请清空内容物，清洁后压扁投放；有尖锐边角的、应包裹后投放
         */

        private String gname;
        private int gtype;
        private int aipre;
        private String explain;
        private String contain;
        private String tip;

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
    }
}
