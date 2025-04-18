package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Controller.ExerciseController;
import com.project.onlineTeach.Mapper.ExerciseMapper;
import com.project.onlineTeach.entity.Exercise;
import com.project.onlineTeach.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
   private   ExerciseMapper exerciseMapper;

    @Override
    public void newExe(Integer exeId,String type,Integer classId) {
        exerciseMapper.newExe(exeId,type,classId);
    }

    @Override
    public void delExe(Integer exeId) {
        exerciseMapper.delExe(exeId);
    }

    @Override
    public Exercise exeInfo(Integer exeId) {
      return   exerciseMapper.exeInfo(exeId);
    }

    @Override
    public List<ExerciseController.ClassExe> getClassExe(Integer classId) {
        return exerciseMapper.getClassExe(classId);
    }
}
