package com.example.woolwichshivajishakha.Model;

public class Sankhya {
    private Integer balStart, balFinish, kishoreStart, kishoreFinish, tarunStart, tarunFinish, yuvaStart, yuvaFinish,
    proudhStart, proudhFinish, anyaStart, anyaFinish, subtotalStart, subtotalFinish, totalStart, totalFinish;
    private String riskassessment, subashita, balShikshaks, ktyShikshaks, balShareerik, ktyShareerik, comments;
    private Boolean firstaid;

    public Sankhya(Integer balStart, Integer balFinish, Integer kishoreStart, Integer kishoreFinish,
                   Integer tarunStart, Integer tarunFinish, Integer yuvaStart, Integer yuvaFinish,
                   Integer proudhStart, Integer proudhFinish,  Integer anyaStart, Integer anyaFinish,
                   Integer subtotalStart, Integer subtotalFinish, Integer totalStart, Integer totalFinish,
                   String riskassessment, String subashita, String balShikshaks,
                   String ktyShikshaks, String balShareerik, String ktyShareerik, String comments, Boolean firstAid){

        this.balStart = balStart;
        this.balFinish = balFinish;
        this.kishoreStart = kishoreStart;
        this.kishoreFinish = kishoreFinish;
        this.tarunStart = tarunStart;
        this.tarunFinish = tarunFinish;
        this.yuvaStart = yuvaStart;
        this.yuvaFinish = yuvaFinish;
        this.proudhStart = proudhStart;
        this.proudhFinish = proudhFinish;
        this.anyaStart = anyaStart;
        this.anyaFinish = anyaFinish;
        this.subtotalStart = subtotalStart;
        this.subtotalFinish = subtotalFinish;
        this.totalStart = totalStart;
        this.totalFinish = totalFinish;
        this.riskassessment = riskassessment;
        this.subashita = subashita;
        this.balShikshaks = balShikshaks;
        this.ktyShikshaks = ktyShikshaks;
        this.balShareerik = balShareerik;
        this.ktyShareerik = ktyShareerik;
        this.comments = comments;
        this.firstaid = firstAid;
    }

    //Set methods

    public void setBalStart(Integer balStart){
        this.balStart = balStart;
    }
    public void setBalFinish(Integer balFinish){
        this.balFinish = balFinish;
    }
    public void setKishoreStart(Integer kishoreStart){
        this.kishoreStart = kishoreStart;
    }
    public void setKishoreFinish(Integer kishoreFinish){
        this.kishoreFinish = kishoreFinish;
    }

    public void setTarunStart(Integer tarunStart){
        this.tarunStart = tarunStart;
    }
    public void setTarunFinish(Integer tarunFinish){
        this.tarunFinish = tarunFinish;
    }
    public void setYuvaStart(Integer yuvaStart){
        this.yuvaStart = yuvaStart;
    }
    public void setYuvaFinish(Integer yuvaFinish){
        this.yuvaFinish = yuvaFinish;
    }
    public void setProudhStart(Integer proudhStart){
        this.proudhStart = proudhStart;
    }
    public void setProudhFinish(Integer proudhFinish){
        this.proudhFinish = proudhFinish;
    }
    public void setAnyaStart(Integer anyaStart){
       this.anyaStart = anyaStart;
    }
    public void setAnyaFinish(Integer anyaFinish){
        this.anyaFinish = anyaFinish;
    }
    public void setSubtotalStart(Integer subtotalStart){
        this.subtotalStart = subtotalStart;
    }
    public void setSubtotalFinish(Integer subtotalFinish){
        this.subtotalFinish = subtotalFinish;
    }
    public void setTotalStart(Integer totalStart){
        this.totalStart = totalStart;
    }
    public void setTotalFinish(Integer totalFinish){
        this.totalFinish = totalFinish;
    }
    public void setRiskassessment(String riskassessment){
        this.riskassessment = riskassessment;
    }
    public void setSubashita(String subashita){
        this.subashita = subashita;
    }
    public void setBalShikshaks(String balShikshaks){
        this.balShikshaks = balShikshaks;
    }
    public void setKtyShikshaks(String ktyShikshaks){
        this.ktyShikshaks = ktyShikshaks;
    }
    public void setBalShareerik(String balShareerik){
        this.balShareerik = balShareerik;
    }
    public void setKtyShareerik(String ktyShareerik){
        this.ktyShareerik = ktyShareerik;
    }
    public void setComments(String comments){
        this.comments = comments;
    }
    public void setFirstAid(Boolean firstAid){
        this.firstaid = firstAid;
    }


    //Get methods

    public Integer getBalStart(){
        return this.balStart;
    }
    public Integer getBalFinish(){
        return this.balFinish;
    }
    public Integer getKishoreStart(){
        return this.kishoreStart;
    }
    public Integer getKishoreFinish(){
        return this.kishoreFinish;
    }

    public Integer getTarunStart(){
        return this.tarunStart;
    }
    public Integer getTarunFinish(){
        return this.tarunFinish;
    }
    public Integer getYuvaStart(){
        return this.yuvaStart;
    }
    public Integer getYuvaFinish(){
        return this.yuvaFinish;
    }
    public Integer getProudhStart(){
        return this.proudhStart;
    }
    public Integer getProudhFinish(){
        return this.proudhFinish;
    }
    public Integer getAnyaStart(){
        return this.anyaStart;
    }
    public Integer getAnyaFinish(){
        return this.anyaFinish;
    }
    public Integer getSubtotalStart(){
        return this.subtotalStart;
    }
    public Integer getSubtotalFinish(){
        return this.subtotalFinish;
    }
    public Integer getTotalStart(){
        return this.totalStart;
    }
    public Integer getTotalFinish(){
        return this.totalFinish;
    }
    public String getRiskassessment(){
        return this.riskassessment;
    }
    public String getSubashita(){
        return this.subashita;
    }
    public String getBalShikshaks(){
        return this.balShikshaks;
    }
    public String getKtyShikshaks(){
        return this.ktyShikshaks;
    }
    public String getBalShareerik(){
        return this.balShareerik;
    }
    public String getKtyShareerik(){
        return this.ktyShareerik;
    }
    public String getComments(){
        return this.comments;
    }
    public Boolean getFirstAid(){
        return this.firstaid;
    }
}
