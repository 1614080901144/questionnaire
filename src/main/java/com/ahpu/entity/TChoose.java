package com.ahpu.entity;

public class TChoose {
    private Integer cid;

    private Integer qid;

    private String questionoption;

    private String optioncontent;
    
    private int click;
    
    
    public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQuestionoption() {
        return questionoption;
    }

    public void setQuestionoption(String questionoption) {
        this.questionoption = questionoption == null ? null : questionoption.trim();
    }

    public String getOptioncontent() {
        return optioncontent;
    }

    public void setOptioncontent(String optioncontent) {
        this.optioncontent = optioncontent == null ? null : optioncontent.trim();
    }
}