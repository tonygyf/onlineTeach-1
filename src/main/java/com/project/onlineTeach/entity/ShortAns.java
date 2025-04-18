package com.project.onlineTeach.entity;

import java.util.Objects;

public class ShortAns {
    private Integer shortAnsId;
    private Integer exeId;
    private String question;
    private String ans;
    private String ansText;
private  Integer paperExeId;

    @Override
    public String toString() {
        return "ShortAns{" +
                "shortAnsId=" + shortAnsId +
                ", exeId=" + exeId +
                ", question='" + question + '\'' +
                ", ans='" + ans + '\'' +
                ", ansText='" + ansText + '\'' +
                ", paperExeId=" + paperExeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortAns shortAns = (ShortAns) o;
        return Objects.equals(shortAnsId, shortAns.shortAnsId) && Objects.equals(exeId, shortAns.exeId) && Objects.equals(question, shortAns.question) && Objects.equals(ans, shortAns.ans) && Objects.equals(ansText, shortAns.ansText) && Objects.equals(paperExeId, shortAns.paperExeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortAnsId, exeId, question, ans, ansText, paperExeId);
    }

    public Integer getShortAnsId() {
        return shortAnsId;
    }

    public void setShortAnsId(Integer shortAnsId) {
        this.shortAnsId = shortAnsId;
    }

    public Integer getExeId() {
        return exeId;
    }

    public void setExeId(Integer exeId) {
        this.exeId = exeId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getAnsText() {
        return ansText;
    }

    public void setAnsText(String ansText) {
        this.ansText = ansText;
    }

    public Integer getPaperExeId() {
        return paperExeId;
    }

    public void setPaperExeId(Integer paperExeId) {
        this.paperExeId = paperExeId;
    }
}
