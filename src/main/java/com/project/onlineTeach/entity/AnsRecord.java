package com.project.onlineTeach.entity;

import java.util.Objects;

public class AnsRecord {
    private String stuId;
   private Integer paperExeId ;
   private String stuAns;
   private Integer stuScore;

    @Override
    public String toString() {
        return "AnsRecord{" +
                "stuId='" + stuId + '\'' +
                ", paperExeId=" + paperExeId +
                ", stuAns='" + stuAns + '\'' +
                ", stuScore=" + stuScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnsRecord ansRecord = (AnsRecord) o;
        return Objects.equals(stuId, ansRecord.stuId) && Objects.equals(paperExeId, ansRecord.paperExeId) && Objects.equals(stuAns, ansRecord.stuAns) && Objects.equals(stuScore, ansRecord.stuScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, paperExeId, stuAns, stuScore);
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getPaperExeId() {
        return paperExeId;
    }

    public void setPaperExeId(Integer paperExeId) {
        this.paperExeId = paperExeId;
    }

    public String getStuAns() {
        return stuAns;
    }

    public void setStuAns(String stuAns) {
        this.stuAns = stuAns;
    }

    public Integer getStuScore() {
        return stuScore;
    }

    public void setStuScore(Integer stuScore) {
        this.stuScore = stuScore;
    }
}
