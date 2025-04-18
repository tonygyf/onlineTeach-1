package com.project.onlineTeach.entity;

import cn.hutool.core.date.DateTime;

import java.util.Objects;

public class Exercise {
    private Integer exeId;
    private String type;
    private String updateTime;

    @Override
    public String toString() {
        return "Exercise{" +
                "exeId=" + exeId +
                ", type='" + type + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(exeId, exercise.exeId) && Objects.equals(type, exercise.type) && Objects.equals(updateTime, exercise.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exeId, type, updateTime);
    }

    public Integer getExeId() {
        return exeId;
    }

    public void setExeId(Integer exeId) {
        this.exeId = exeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
