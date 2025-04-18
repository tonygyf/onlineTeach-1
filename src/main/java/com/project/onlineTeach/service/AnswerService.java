package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.AnsRecord;

import java.util.List;

public interface AnswerService {
    void newAns(String stuId, List<AnsRecord> answers);

    void updateScore(Integer score, Integer paperExeId, String stuId);

    void delRecord(Integer exeId);
}
