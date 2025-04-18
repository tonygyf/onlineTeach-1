package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.ShortAns;

public interface ShortAnsService {
    ShortAns getInfo(Integer shortAnsId);

    void addShortAns(ShortAns shortAns);

    void delShortAns(Integer shortAnsId, Integer exeId);

    void updateShortAns(ShortAns shortAns);

    ShortAns getShortAns(Integer exeId);
}
