package com.project.onlineTeach.entity;

import java.util.Objects;

public class Judge {
    private Integer judgeId;
    private Integer exeId;
    private String question;
    private Integer ans;
    private String ansText;
private Integer paperExeId;

    @Override
    public String toString() {
        return "Judge{" +
                "judgeId=" + judgeId +
                ", exeId=" + exeId +
                ", question='" + question + '\'' +
                ", ans=" + ans +
                ", ansText='" + ansText + '\'' +
                ", paperExeId=" + paperExeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Judge judge = (Judge) o;
        return Objects.equals(judgeId, judge.judgeId) && Objects.equals(exeId, judge.exeId) && Objects.equals(question, judge.question) && Objects.equals(ans, judge.ans) && Objects.equals(ansText, judge.ansText) && Objects.equals(paperExeId, judge.paperExeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(judgeId, exeId, question, ans, ansText, paperExeId);
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
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

    public Integer getAns() {
        return ans;
    }

    public void setAns(Integer ans) {
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
