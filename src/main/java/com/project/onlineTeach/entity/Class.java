package com.project.onlineTeach.entity;

import java.util.Objects;

public class Class {
    private Integer classId;
    private Integer stuNum;
    private String courseId;
    private String teaId;
    private String logo;

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", stuNum=" + stuNum +
                ", courseId='" + courseId + '\'' +
                ", teaId='" + teaId + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStuNum() {
        return stuNum;
    }

    public void setStuNum(Integer stuNum) {
        this.stuNum = stuNum;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(classId, aClass.classId) && Objects.equals(stuNum, aClass.stuNum) && Objects.equals(courseId, aClass.courseId) && Objects.equals(teaId, aClass.teaId) && Objects.equals(logo, aClass.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, stuNum, courseId, teaId, logo);
    }
}
