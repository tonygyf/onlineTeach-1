package com.project.onlineTeach.entity;

import cn.hutool.core.date.DateTime;

import java.util.Objects;

public class Paper {
   private Integer paperId;
   private Integer type;
   private Integer tolScore;
   private Integer standardScore;
   private String startTime;
   private String endTime;
   private String updateTime;
   private Integer state;
   private Integer duration;
   private Integer classId;
   private String paperTitle;

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", type=" + type +
                ", tolScore=" + tolScore +
                ", standardScore=" + standardScore +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", state=" + state +
                ", duration=" + duration +
                ", classId=" + classId +
                ", paperTitle='" + paperTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return Objects.equals(paperId, paper.paperId) && Objects.equals(type, paper.type) && Objects.equals(tolScore, paper.tolScore) && Objects.equals(standardScore, paper.standardScore) && Objects.equals(startTime, paper.startTime) && Objects.equals(endTime, paper.endTime) && Objects.equals(updateTime, paper.updateTime) && Objects.equals(state, paper.state) && Objects.equals(duration, paper.duration) && Objects.equals(classId, paper.classId) && Objects.equals(paperTitle, paper.paperTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperId, type, tolScore, standardScore, startTime, endTime, updateTime, state, duration, classId, paperTitle);
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTolScore() {
        return tolScore;
    }

    public void setTolScore(Integer tolScore) {
        this.tolScore = tolScore;
    }

    public Integer getStandardScore() {
        return standardScore;
    }

    public void setStandardScore(Integer standardScore) {
        this.standardScore = standardScore;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }
}
