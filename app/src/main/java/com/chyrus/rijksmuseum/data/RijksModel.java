package com.chyrus.rijksmuseum.data;

import java.io.Serializable;

public class RijksModel implements Serializable{

    private String title;
    private String desc;
    private String img;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
