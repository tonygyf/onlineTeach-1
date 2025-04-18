package com.project.onlineTeach.entity;

import java.util.Objects;

public class Course {
     private String courseId;
     private Integer credit;
     private String courseTime;
     private String place;
     private String term;
     private String courseName;
     private String syllabus;
     private String syllabusUrl;

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", credit=" + credit +
                ", courseTime='" + courseTime + '\'' +
                ", place='" + place + '\'' +
                ", term='" + term + '\'' +
                ", courseName='" + courseName + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", syllabusUrl='" + syllabusUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) && Objects.equals(credit, course.credit) && Objects.equals(courseTime, course.courseTime) && Objects.equals(place, course.place) && Objects.equals(term, course.term) && Objects.equals(courseName, course.courseName) && Objects.equals(syllabus, course.syllabus) && Objects.equals(syllabusUrl, course.syllabusUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, credit, courseTime, place, term, courseName, syllabus, syllabusUrl);
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getSyllabusUrl() {
        return syllabusUrl;
    }

    public void setSyllabusUrl(String syllabusUrl) {
        this.syllabusUrl = syllabusUrl;
    }
}
