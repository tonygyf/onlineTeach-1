package com.project.onlineTeach.entity;

import java.util.Objects;

public class Teacher {
    private String teaId;
    private String teaName;
    private String sex;
    private String phone;
    private String email;
    private String job;
    private String courses;
    private String selfInfo;
    private Integer accId;

    @Override
    public String toString() {
        return "teacher{" +
                "teaId='" + teaId + '\'' +
                ", teaName='" + teaName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", courses='" + courses + '\'' +
                ", selfInfo='" + selfInfo + '\'' +
                ", accId=" + accId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teaId, teacher.teaId) && Objects.equals(teaName, teacher.teaName) && Objects.equals(sex, teacher.sex) && Objects.equals(phone, teacher.phone) && Objects.equals(email, teacher.email) && Objects.equals(job, teacher.job) && Objects.equals(courses, teacher.courses) && Objects.equals(selfInfo, teacher.selfInfo) && Objects.equals(accId, teacher.accId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teaId, teaName, sex, phone, email, job, courses, selfInfo, accId);
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getSelfInfo() {
        return selfInfo;
    }

    public void setSelfInfo(String selfInfo) {
        this.selfInfo = selfInfo;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }
}
