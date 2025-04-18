package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Judge;

public interface JudgeService {
    Judge getInfo(Integer judgeId);

    void addJudge(Judge judge);

    void updateJudge(Judge judge);

    void delJudge(Integer judgeId,Integer exeId);

    Judge getJudge(Integer exeId);
}
