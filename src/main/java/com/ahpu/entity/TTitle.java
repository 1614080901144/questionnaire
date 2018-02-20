package com.ahpu.entity;

import java.util.Date;

public class TTitle {
    private Integer tid;

    private String title;

    private String subtitle;

    private Date joindate;

    private String forwho;

    private String state;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public String getForwho() {
        return forwho;
    }

    public void setForwho(String forwho) {
        this.forwho = forwho == null ? null : forwho.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}