package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.MakePaperMapper;
import com.project.onlineTeach.entity.*;
import com.project.onlineTeach.service.ExamService;
import com.project.onlineTeach.service.MakePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakePaperServiceImpl implements MakePaperService {
    @Autowired
    private MakePaperMapper makePaperMapper;
    @Autowired
    private ExamService examService;
    @Override
    public void makeNewPaper(Integer paperId, List<PaperExe> paperExes) {
        for(PaperExe paperExe:paperExes){
            paperExe.setPaperId(paperId);
        }
        makePaperMapper.makeNewPaper(paperExes);
    }

    @Override
    public List<PaperExe> getInfo(Integer paperId) {
         return makePaperMapper.getInfo(paperId);
    }

    @Override
    public void delPaperExe(Integer paperExeId) {
        makePaperMapper.delPaperExe(paperExeId);
    }

    @Override
    public void updateScore(Integer paperExeId,Integer score) {
        makePaperMapper.updateScore(paperExeId ,score);
    }

    @Override
    public List<Choose> getAllChoose(Integer paperId) {
     return    makePaperMapper.getAllChoose(paperId);
    }

    @Override
    public List<Blank> getAllBlank(Integer paperId) {
        return makePaperMapper.getAllBlank(paperId);
    }

    @Override
    public List<Judge> getAllJudge(Integer paperId) {
        return makePaperMapper.getAllJudge(paperId);
    }

    @Override
    public List<ShortAns> getAllShortAns(Integer paperId) {
        return makePaperMapper.getAllShortAns(paperId);
    }

    @Override
    public void delByExeId(Integer exeId) {
        makePaperMapper.delByExeId(exeId);
    }


}
