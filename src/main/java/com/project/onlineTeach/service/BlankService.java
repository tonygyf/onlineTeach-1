package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Blank;

public interface BlankService {
    void addBlank(Blank blank);

    Blank getInfo(Integer blankId);

    void updateBlank(Blank blank);

    void delBlank(Integer blankId,Integer exeId);

    Blank getBlank(Integer exeId);
}
