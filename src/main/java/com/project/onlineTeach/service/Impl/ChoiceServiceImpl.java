package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.ChoiceMapper;
import com.project.onlineTeach.entity.Choose;
import com.project.onlineTeach.service.AnswerService;
import com.project.onlineTeach.service.ChoiceService;
import com.project.onlineTeach.service.ExerciseService;
import com.project.onlineTeach.service.MakePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceServiceImpl implements ChoiceService {
    @Autowired
    private ChoiceMapper choiceMapper;
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private MakePaperService makePaperService;
    @Override
    public void newChoice(Choose choose) {
        choiceMapper.newChoice(choose);
    }

    @Override
    public void delChoice(Integer chooseId,Integer exeId) {
        answerService.delRecord(exeId);
        makePaperService.delByExeId(exeId);
        choiceMapper.delChoice(chooseId);
        exerciseService.delExe(exeId);
    }

    @Override
    public void updateChoice(Choose choose) {
        choiceMapper.updateChoice(choose);
    }

    @Override
    public Choose choiceInfo(Integer chooseId) {
      return   choiceMapper.choiceInfo(chooseId);
    }

    @Override
    public Choose getChoose(Integer exeId) {
        return choiceMapper.getChoose(exeId);
    }
}
