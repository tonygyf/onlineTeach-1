package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Course;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.CourseService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/add")
    public Result addCourse(@Validated @RequestBody Course course){
        /**
         * 添加课程
         */
        String courseId =course.getCourseId();
       Course findCourse= courseService.findByCourseId(courseId);
       if(findCourse!=null){
           return Result.error("课程编号重复，请重新编号！");
       }
        courseService.add(course);
        return Result.success();
    }
    @GetMapping("/syllabus")
    public Result getSyllabus(@RequestParam String courseId){
        /**
         * 获取课程大纲
         */
      String syllabusUrl=  courseService.getSyllabus(courseId);
        return Result.success(syllabusUrl);
    }
    @PutMapping("/updateSyllabus")
    public Result updateSyllabus(@RequestParam String pdfUrl,String courseId){
        courseService.updateSyllabus(pdfUrl,courseId);
        return  Result.success();
    }
    @DeleteMapping("/delete")
    public Result deleteByCourseId(@RequestParam String courseId){
        courseService.deleteByCourseId(courseId);
        return Result.success();
    }
    @PutMapping("/update")
    public Result updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
        return Result.success();
    }
    @GetMapping("/info")
    public Result getCourseInfo(@RequestParam String courseId){
       Course course= courseService.getCourseInfo(courseId);
        return Result.success(course);
    }
}
