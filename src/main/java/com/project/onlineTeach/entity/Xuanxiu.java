package com.project.onlineTeach.entity;

import java.util.Objects;

public class Xuanxiu {
    private String stuId;
    private Integer score;
    private Integer classId;

    @Override
    public String toString() {
        return "Xuanxiu{" +
                "stuId='" + stuId + '\'' +
                ", score=" + score +
                ", classId=" + classId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xuanxiu xuanxiu = (Xuanxiu) o;
        return Objects.equals(stuId, xuanxiu.stuId) && Objects.equals(score, xuanxiu.score) && Objects.equals(classId, xuanxiu.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, score, classId);
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
