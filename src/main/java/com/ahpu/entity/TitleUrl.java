package com.ahpu.entity;

public class TitleUrl {
    private Integer uid;

    private Integer tid;

    private String url;

    private Integer ustate;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getUstate() {
        return ustate;
    }

    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }
}