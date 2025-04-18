package com.project.onlineTeach.entity;

import java.util.Objects;

public class Admin {
    private Integer adminId;
    private String sex;
    private String job;
    private Integer accId;

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", sex='" + sex + '\'' +
                ", job='" + job + '\'' +
                ", accId=" + accId +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(sex, admin.sex) && Objects.equals(job, admin.job) && Objects.equals(accId, admin.accId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, sex, job, accId);
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }
}
