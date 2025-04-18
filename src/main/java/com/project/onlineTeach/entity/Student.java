package com.project.onlineTeach.entity;

import java.util.Objects;

public class Student {
    private String stuId;
    private String stuName;
    private String sex;
    private String type;
    private String dept;
    private String major;
    private String grade;
    private String adminClass;
    private Integer accId;
    private Integer score;

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                ", type='" + type + '\'' +
                ", dept='" + dept + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", adminClass='" + adminClass + '\'' +
                ", accId=" + accId +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(stuId, student.stuId) && Objects.equals(stuName, student.stuName) && Objects.equals(sex, student.sex) && Objects.equals(type, student.type) && Objects.equals(dept, student.dept) && Objects.equals(major, student.major) && Objects.equals(grade, student.grade) && Objects.equals(adminClass, student.adminClass) && Objects.equals(accId, student.accId) && Objects.equals(score, student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, stuName, sex, type, dept, major, grade, adminClass, accId, score);
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAdminClass() {
        return adminClass;
    }

    public void setAdminClass(String adminClass) {
        this.adminClass = adminClass;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
