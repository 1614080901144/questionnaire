package com.ahpu.entity;

public class TGetquestion {
    private Integer getid;

    private Integer titleid;

    private Integer questionid;

    private String choose;

    private String submituser;

    private Integer choosenum;

    private Integer ismultiple;

    public Integer getGetid() {
        return getid;
    }

    public void setGetid(Integer getid) {
        this.getid = getid;
    }

    public Integer getTitleid() {
        return titleid;
    }

    public void setTitleid(Integer titleid) {
        this.titleid = titleid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose == null ? null : choose.trim();
    }

    public String getSubmituser() {
        return submituser;
    }

    public void setSubmituser(String submituser) {
        this.submituser = submituser == null ? null : submituser.trim();
    }

    public Integer getChoosenum() {
        return choosenum;
    }

    public void setChoosenum(Integer choosenum) {
        this.choosenum = choosenum;
    }

    public Integer getIsmultiple() {
        return ismultiple;
    }

    public void setIsmultiple(Integer ismultiple) {
        this.ismultiple = ismultiple;
    }
}