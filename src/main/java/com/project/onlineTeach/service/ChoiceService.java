package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Choose;

public interface ChoiceService {
    void newChoice(Choose choose);

    void delChoice(Integer chooseId,Integer exeId);

    void updateChoice(Choose choose);
    Choose choiceInfo(Integer chooseId);

    Choose getChoose(Integer exeId);
}
