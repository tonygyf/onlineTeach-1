package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Paper;
import com.project.onlineTeach.entity.PaperExe;

import java.util.List;

public interface PaperService {
    void newPaper(Paper paper);

    Paper getInfo(Integer paperId);

    void updatePaper(Paper paperId);

    void delPaper(Integer paperId);

    List<Paper> getClassPaper(Integer classId,Integer type);

    Integer getStuPaperState(Integer paperId, String username);

    List<Paper> getTestAndExam(Integer classId);
}
