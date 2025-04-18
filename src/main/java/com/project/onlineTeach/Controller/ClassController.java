package com.project.onlineTeach.Controller;

import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.Class;
import com.project.onlineTeach.entity.Course;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.entity.Student;
import com.project.onlineTeach.service.ClassService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/getAllClass")
    public Result getAllClass(){
        /**
         * 获取所有课程和班级信息
         */
     List<ClassAndCourse> classAndCourses= classService.getAllClass();
     return Result.success(classAndCourses);
    }
    @GetMapping("/teaGetClass")
    public Result teaGetClass(){
        /**
         * 教师获取班级信息
         */
        List<ClassAndCourse> classAndCourses =classService.teaGetClass();
        return Result.success(classAndCourses);
    }
     @GetMapping ("/info")
    public Result getClassInfo(Integer classId){
         /**
          * 获取班级信息
          */
     Class targetClass= classService.getClassInfo(classId);
        return Result.success(targetClass);
    }
    @PostMapping("/add")
    public  Result addClass(@Validated @RequestBody Class newClass){
        /**
         * 新增班级
         */
            classService.addClass(newClass);
            return Result.success();
    }
    @DeleteMapping("/del")
    public Result delClass(@RequestParam Integer classId){
        /**
         * 删除班级
         */
        classService.delClass(classId);
        return Result.success();
    }
    @PostMapping("/addStu")
    public Result addStuToClass(@RequestParam String stuId,Integer classId){
        /**
         * 添加学生
         */
        Map<String, Object> map = ThreadLocalUtil.get();
        String teaId = (String) map.get("username");
        classService.addStuToClass(stuId,classId);
        return  Result.success();
    }
    @PutMapping("/finalScore")
    public Result giveFinalScore(@RequestParam Integer score,String stuId,Integer classId){
        /**
         * 教师给出总评成绩
         */
        classService.giveFinalScore(score,stuId,classId);
        return  Result.success();
    }
    @GetMapping("/getSummaryScore")
    public Result getSummaryScore(@RequestParam String stuId,Integer classId){
        /**
         * 学生获取总评成绩
         */
     Integer summaryScore=   classService.getSummaryScore(stuId,classId);
        return Result.success(summaryScore);
    }
    @DeleteMapping("/delFromClass")
    public  Result delFormClass(@RequestParam String stuId ,Integer classId){
        /**
         * 从班级删除学生
         */
        classService.delFormClass(stuId,classId);
        return Result.success();
    }
    @PostMapping("/batchImport")
    public String batchImport(@RequestParam("file") MultipartFile file) {

        /**
         * 批量导入学生信息，传入Excel文件 表头  stuId,classId,score
         */
        try {
            classService.batchImport(file);
            return "Batch import successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Batch import failed: " + e.getMessage();
        }
    }
    static public class ClassAndCourse{
        private Integer classId;
        private Integer stuNum;
        private String courseId;
        private String teaId;
        private String logo;

        private Integer credit;
        private String courseTime;
        private String place;
        private String term;
        private String courseName;
        private String syllabus;
        private String syllabusUrl;

        @Override
        public String toString() {
            return "ClassAndCourse{" +
                    "classId=" + classId +
                    ", stuNum=" + stuNum +
                    ", courseId='" + courseId + '\'' +
                    ", teaId='" + teaId + '\'' +
                    ", logo='" + logo + '\'' +
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
            ClassAndCourse that = (ClassAndCourse) o;
            return Objects.equals(classId, that.classId) && Objects.equals(stuNum, that.stuNum) && Objects.equals(courseId, that.courseId) && Objects.equals(teaId, that.teaId) && Objects.equals(logo, that.logo) && Objects.equals(credit, that.credit) && Objects.equals(courseTime, that.courseTime) && Objects.equals(place, that.place) && Objects.equals(term, that.term) && Objects.equals(courseName, that.courseName) && Objects.equals(syllabus, that.syllabus) && Objects.equals(syllabusUrl, that.syllabusUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(classId, stuNum, courseId, teaId, logo, credit, courseTime, place, term, courseName, syllabus, syllabusUrl);
        }

        public Integer getClassId() {
            return classId;
        }

        public void setClassId(Integer classId) {
            this.classId = classId;
        }

        public Integer getStuNum() {
            return stuNum;
        }

        public void setStuNum(Integer stuNum) {
            this.stuNum = stuNum;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getTeaId() {
            return teaId;
        }

        public void setTeaId(String teaId) {
            this.teaId = teaId;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
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

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
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
}
