package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.AnswerMapper;
import com.project.onlineTeach.entity.AnsRecord;
import com.project.onlineTeach.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public void newAns(String stuId, List<AnsRecord> answers) {
        for (AnsRecord ansRecord:answers){
            ansRecord.setStuId(stuId);
        }
        answerMapper.newAns(answers);
    }

    @Override
    public void updateScore(Integer score, Integer paperExeId, String stuId) {
        answerMapper.updateScore(score,paperExeId,stuId);
    }

    @Override
    public void delRecord(Integer exeId) {
        answerMapper.delRecord(exeId);
    }
}
