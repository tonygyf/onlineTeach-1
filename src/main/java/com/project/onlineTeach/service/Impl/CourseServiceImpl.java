package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.CourseMapper;
import com.project.onlineTeach.entity.Course;
import com.project.onlineTeach.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void add(Course course) {

        courseMapper.add(course);
    }

    @Override
    public Course findByCourseId(String courseId) {
       return   courseMapper.findByCourseId(courseId);
    }

    @Override
    public void updateSyllabus(String pdfUrl, String courseId) {
        courseMapper.updateSyllabus(pdfUrl,courseId);
    }

    @Override
    public void deleteByCourseId(String courseId) {
        courseMapper.deleteByCourseId(courseId);
    }

    @Override
    public String getSyllabus(String courseId) {
    String syllabusUrl=    courseMapper.getSyllabus(courseId);
    return syllabusUrl;
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    @Override
    public Course getCourseInfo(String courseId) {

      return   courseMapper.getCourseInfo(courseId);
    }
}
