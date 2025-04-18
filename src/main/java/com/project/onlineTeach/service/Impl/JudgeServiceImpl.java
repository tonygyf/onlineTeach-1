package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.ExerciseMapper;
import com.project.onlineTeach.Mapper.JudgeMapper;
import com.project.onlineTeach.entity.Judge;
import com.project.onlineTeach.service.AnswerService;
import com.project.onlineTeach.service.ExerciseService;
import com.project.onlineTeach.service.JudgeService;
import com.project.onlineTeach.service.MakePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JudgeServiceImpl implements JudgeService {
    @Autowired
 private    JudgeMapper judgeMapper;
    @Autowired
    private ExerciseMapper exerciseMapper;
    @Autowired
    private MakePaperService makePaperService;
    @Autowired
    private AnswerService answerService;
    @Override
    public Judge getInfo(Integer judgeId) {
       return   judgeMapper.getInfo(judgeId);
    }

    @Override
    public void addJudge(Judge judge) {
            judgeMapper.addJudge(judge);
    }

    @Override
    public void updateJudge(Judge judge) {
judgeMapper.updateJudge(judge);
    }

    @Override
    public void delJudge(Integer judgeId,Integer exeId) {
        answerService.delRecord(exeId);
        makePaperService.delByExeId(exeId);
    judgeMapper.delJudge(judgeId);
    exerciseMapper.delExe(exeId);
    }

    @Override
    public Judge getJudge(Integer exeId) {
        return judgeMapper.getJudge(exeId);
    }
}
