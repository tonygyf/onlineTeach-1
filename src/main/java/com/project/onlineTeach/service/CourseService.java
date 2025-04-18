package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Course;

public interface CourseService {
    void add(Course course);

    Course findByCourseId(String courseId);

    void updateSyllabus(String pdfUrl, String courseId);

    void deleteByCourseId(String courseId);

    String getSyllabus(String courseId);

    void updateCourse(Course course);

    Course getCourseInfo(String courseId);
}
