package com.project.onlineTeach.service;

import com.project.onlineTeach.Controller.ExamController;
import com.project.onlineTeach.entity.ExamRecord;

import java.util.List;

public interface ExamService {
    void giveScore(Integer score,String stuId,Integer paperId);

    void addRecord(  Integer paperId,Integer time);

    ExamRecord getInfo(String stuId, Integer paperId);

    List<ExamRecord> getSelfClassExam(String stuId, Integer classId);

    ExamController.AnsAndMyRecord getAnsAndMyRecord(Integer paperId,Integer type);

    void getObjectScore(Integer paperId);

    List<ExamRecord> getStuExamState(Integer paperId);
}
