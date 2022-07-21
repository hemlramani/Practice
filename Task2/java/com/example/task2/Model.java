package com.example.task2;
public class Model
{
    int img;
    String nm,prc;

    Model(int img,String nm, String prc)
    {
        this.img=img;
        this.nm=nm;
        this.prc=prc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getPrc() {
        return prc;
    }

    public void setPrc(String prc) {
        this.prc = prc;
    }



}
