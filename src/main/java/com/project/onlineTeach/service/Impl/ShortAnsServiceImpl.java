package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.ExerciseMapper;
import com.project.onlineTeach.Mapper.ShortAnsMapper;
import com.project.onlineTeach.entity.ShortAns;
import com.project.onlineTeach.service.AnswerService;
import com.project.onlineTeach.service.MakePaperService;
import com.project.onlineTeach.service.ShortAnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortAnsServiceImpl implements ShortAnsService {

    @Autowired
    private ShortAnsMapper shortAnsMapper;
    @Autowired
    private ExerciseMapper exerciseMapper;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private MakePaperService makePaperService;
    @Override
    public ShortAns getInfo(Integer shortAnsId) {
        return shortAnsMapper.getInfo(shortAnsId);
    }

    @Override
    public void addShortAns(ShortAns shortAns) {
shortAnsMapper.addShortAns(shortAns);
    }

    @Override
    public void delShortAns(Integer shortAnsId, Integer exeId) {
        answerService.delRecord(exeId);
        makePaperService.delByExeId(exeId);
        shortAnsMapper.delShortAns(shortAnsId);
        exerciseMapper.delExe(exeId);
    }

    @Override
    public void updateShortAns(ShortAns shortAns) {
shortAnsMapper.updateShortAns(shortAns);
    }

    @Override
    public ShortAns getShortAns(Integer exeId) {
        return shortAnsMapper.getShortAns(exeId);
    }
}
