package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Teacher;

public interface TeacherService {
    void newInfo(Teacher teacher);

    void updateInfo(Teacher teacher);

    Teacher findById(String teaId);

    void deleteById(String teaId);
}
