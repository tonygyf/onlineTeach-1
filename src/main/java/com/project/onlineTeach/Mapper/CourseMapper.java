package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Course;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CourseMapper {
    @Insert("insert into course(courseId,courseName,credit,courseTime,place,term,syllabus,syllabusUrl) values (#{courseId},#{courseName},#{credit},#{courseTime},#{place},#{term},#{syllabus},#{syllabusUrl})")
    void add(Course course);
    @Select("select * from course where courseId=#{courseId}")
    Course findByCourseId(String courseId);
    @Update("update course set syllabusUrl=#{pdfUrl} where courseId=#{courseId}")
    void updateSyllabus(String pdfUrl, String courseId);
    @Delete("DELETE FROM COURSE WHERE courseId=#{courseId}")
    void deleteByCourseId(String courseId);
    @Select("SELECT syllabusUrl  FROM COURSE WHERE courseId=#{courseId}")
    String getSyllabus(String courseId);
    @Update("update course set courseName=#{courseName},credit=#{credit},courseTime=#{courseTime},place=#{place},term=#{term},syllabus=#{syllabus} where courseId=#{courseId}")
    void updateCourse(Course course);
    @Select("select * from course where courseId=#{courseId}")
    Course getCourseInfo(String courseId);
}
