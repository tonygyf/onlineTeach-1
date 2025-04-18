package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Admin;
import com.project.onlineTeach.entity.Course;
import com.project.onlineTeach.entity.Student;
import com.project.onlineTeach.entity.Teacher;

import java.util.List;

public interface AdminService {
    void newAdmin(Admin admin);

    Admin getInfo(Integer adminId);

    List<Student> getStu();

    void delFromXuanxiu(String stuId);

    void delFromStu(String stuId);

    void delFromAnsRecord(String stuId);

    void delFromExamRecord(String stuId);

    List<Teacher> getTea();

    List<Course> getCourse();
}
