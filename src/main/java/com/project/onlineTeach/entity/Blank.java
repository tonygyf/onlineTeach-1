package com.project.onlineTeach.entity;

import java.util.Objects;

public class Blank {
   private Integer blankId;
   private Integer exeId;
   private String question;
   private String ans;
   private String ansText;
private  Integer paperExeId;

    @Override
    public String toString() {
        return "Blank{" +
                "blankId=" + blankId +
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
        Blank blank = (Blank) o;
        return Objects.equals(blankId, blank.blankId) && Objects.equals(exeId, blank.exeId) && Objects.equals(question, blank.question) && Objects.equals(ans, blank.ans) && Objects.equals(ansText, blank.ansText) && Objects.equals(paperExeId, blank.paperExeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blankId, exeId, question, ans, ansText, paperExeId);
    }

    public Integer getBlankId() {
        return blankId;
    }

    public void setBlankId(Integer blankId) {
        this.blankId = blankId;
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
