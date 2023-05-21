package com.example.weswing.objects;

public class Novetats {
    private int pfp;
    private String desc;
    private String hores;

    public Novetats(int pfp, String desc, String hores) {
        this.pfp = pfp;
        this.desc = desc;
        this.hores = hores;
    }

    public int getPfp() {
        return pfp;
    }

    public void setPfp(int pfp) {
        this.pfp = pfp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHores() {
        return hores;
    }

    public void setHores(String hores) {
        this.hores = hores;
    }
}
