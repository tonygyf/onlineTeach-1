package com.project.onlineTeach.service;

import com.project.onlineTeach.Controller.ClassController;
import com.project.onlineTeach.entity.Class;
import com.project.onlineTeach.entity.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClassService {
    Class getClassInfo(Integer classId);

    void addClass(Class newClass);

    void delClass(Integer classId);

    void addStuToClass(String stuId, Integer classId);

    void giveFinalScore(Integer score,String stuId, Integer classId);

    void batchImport(MultipartFile file) throws Exception;

    List<ClassController.ClassAndCourse> getAllClass();

    Integer getSummaryScore(String stuId, Integer classId);

    List<ClassController.ClassAndCourse> teaGetClass();

    void delFormClass(String stuId, Integer classId);
}
