package com.project.onlineTeach.entity;

import java.util.Objects;

public class Choose {
    private Integer chooseId;
    private Integer exeId;
    private String question;
    private String ans;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String ansText;
    private Integer paperExeId;

    @Override
    public String toString() {
        return "Choose{" +
                "chooseId=" + chooseId +
                ", exeId=" + exeId +
                ", question='" + question + '\'' +
                ", ans='" + ans + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", ansText='" + ansText + '\'' +
                ", paperExeId=" + paperExeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Choose choose = (Choose) o;
        return Objects.equals(chooseId, choose.chooseId) && Objects.equals(exeId, choose.exeId) && Objects.equals(question, choose.question) && Objects.equals(ans, choose.ans) && Objects.equals(optionA, choose.optionA) && Objects.equals(optionB, choose.optionB) && Objects.equals(optionC, choose.optionC) && Objects.equals(optionD, choose.optionD) && Objects.equals(ansText, choose.ansText) && Objects.equals(paperExeId, choose.paperExeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chooseId, exeId, question, ans, optionA, optionB, optionC, optionD, ansText, paperExeId);
    }

    public Integer getChooseId() {
        return chooseId;
    }

    public void setChooseId(Integer chooseId) {
        this.chooseId = chooseId;
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

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
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
