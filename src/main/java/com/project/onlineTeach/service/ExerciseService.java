package com.project.onlineTeach.service;

import com.project.onlineTeach.Controller.ExerciseController;
import com.project.onlineTeach.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    void newExe(Integer exeId,String type,Integer classId);

    void delExe(Integer exeId);

    Exercise exeInfo(Integer exeId);

    List<ExerciseController.ClassExe> getClassExe(Integer classId);
}
