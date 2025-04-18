package com.project.onlineTeach.entity;

import java.util.Objects;

public class PaperExe {
    private Integer paperExeId;
    private Integer paperId;
    private Integer exeId;
    private Integer score;

    @Override
    public String toString() {
        return "PaperExe{" +
                "paperExeId=" + paperExeId +
                ", paperId=" + paperId +
                ", exeId=" + exeId +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperExe paperExe = (PaperExe) o;
        return Objects.equals(paperExeId, paperExe.paperExeId) && Objects.equals(paperId, paperExe.paperId) && Objects.equals(exeId, paperExe.exeId) && Objects.equals(score, paperExe.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperExeId, paperId, exeId, score);
    }

    public Integer getPaperExeId() {
        return paperExeId;
    }

    public void setPaperExeId(Integer paperExeId) {
        this.paperExeId = paperExeId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getExeId() {
        return exeId;
    }

    public void setExeId(Integer exeId) {
        this.exeId = exeId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
