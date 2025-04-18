package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.*;

import java.util.List;

public interface MakePaperService {
    void makeNewPaper(Integer paperId, List<PaperExe> paperExes);
    List<PaperExe>getInfo(Integer paperId);

    void delPaperExe(Integer paperExeId);

    void updateScore(Integer paperExeId,Integer score);

    List<Choose> getAllChoose(Integer paperId);

    List<Blank> getAllBlank(Integer paperId);

    List<Judge> getAllJudge(Integer paperId);

    List<ShortAns> getAllShortAns(Integer paperId);

    void delByExeId(Integer exeId);
}
