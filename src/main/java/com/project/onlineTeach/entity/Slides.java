package com.project.onlineTeach.entity;

import java.util.Objects;

public class Slides {
    private Integer slidesId;
    private String courseId;
    private String title;
    private String url;
    private Integer sectionId;

    @Override
    public String toString() {
        return "Slides{" +
                "slidesId=" + slidesId +
                ", courseId='" + courseId + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", sectionId=" + sectionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slides slides = (Slides) o;
        return Objects.equals(slidesId, slides.slidesId) && Objects.equals(courseId, slides.courseId) && Objects.equals(title, slides.title) && Objects.equals(url, slides.url) && Objects.equals(sectionId, slides.sectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slidesId, courseId, title, url, sectionId);
    }

    public Integer getSlidesId() {
        return slidesId;
    }

    public void setSlidesId(Integer slidesId) {
        this.slidesId = slidesId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }
}
