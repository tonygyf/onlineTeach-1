package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Student;

import java.util.List;

public interface StudentService {
    void newInfo(Student stu);

    void updateInfo(Student stu);

    Student findById(String stuId);

    void deleteById(String stuId);

    List<Student> getAllStu(String classId);
}
