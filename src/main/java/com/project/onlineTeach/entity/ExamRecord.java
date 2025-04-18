package com.project.onlineTeach.entity;

import java.util.Objects;

public class ExamRecord {
    private String stuId;
    private Integer paperId;
    private Integer time;
    private Integer score;
    private Integer state;

    @Override
    public String toString() {
        return "ExamRecord{" +
                "stuId='" + stuId + '\'' +
                ", paperId=" + paperId +
                ", time=" + time +
                ", score=" + score +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamRecord that = (ExamRecord) o;
        return Objects.equals(stuId, that.stuId) && Objects.equals(paperId, that.paperId) && Objects.equals(time, that.time) && Objects.equals(score, that.score) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, paperId, time, score, state);
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
