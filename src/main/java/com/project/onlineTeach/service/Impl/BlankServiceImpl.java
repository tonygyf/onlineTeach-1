package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.BlankMapper;
import com.project.onlineTeach.Mapper.ExerciseMapper;
import com.project.onlineTeach.entity.Blank;
import com.project.onlineTeach.service.AnswerService;
import com.project.onlineTeach.service.BlankService;
import com.project.onlineTeach.service.ExerciseService;
import com.project.onlineTeach.service.MakePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlankServiceImpl implements BlankService {
    @Autowired
    private BlankMapper blankMapper;
    @Autowired
    private ExerciseMapper exerciseMapper;
    @Autowired
    private MakePaperService makePaperService;
    @Autowired
    private AnswerService answerService;
    @Override
    public void addBlank(Blank blank) {
        blankMapper.addBlank(blank);
    }

    @Override
    public Blank getInfo(Integer blankId) {
        return blankMapper.getInfo(blankId);

    }

    @Override
    public void updateBlank(Blank blank) {
        blankMapper.updateBlank(blank);
    }

    @Override
    public void delBlank(Integer blankId,Integer exeId) {
        answerService.delRecord(exeId);
        makePaperService.delByExeId(exeId);
        blankMapper.delBlank(blankId);
        exerciseMapper.delExe(exeId);
    }

    @Override
    public Blank getBlank(Integer exeId) {
        return blankMapper.getBlank(exeId);
    }
}
