package com.project.onlineTeach.service.Impl;

import cn.hutool.core.date.DateTime;
import com.project.onlineTeach.Mapper.PaperMapper;
import com.project.onlineTeach.entity.Paper;
import com.project.onlineTeach.entity.PaperExe;
import com.project.onlineTeach.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public void newPaper(Paper paper) {
       DateTime start=new DateTime( paper.getStartTime());
       DateTime end=new DateTime( paper.getEndTime());
       Integer duration=(int) ((end.getTime()-start.getTime())/60000);

        paperMapper.newPaper(paper,duration);

    }

    @Override
    public Paper getInfo(Integer paperId) {
        return paperMapper.getInfo(paperId);
    }

    @Override
    public void updatePaper(Paper paper) {
        DateTime start=new DateTime( paper.getStartTime());
        DateTime end=new DateTime( paper.getEndTime());
        Integer duration=(int) ((end.getTime()-start.getTime())/60000);
        paperMapper.updatePaper(paper,duration);
    }

    @Override
    public void delPaper(Integer paperId) {
        paperMapper.delPaper(paperId);
    }

    @Override
    public List<Paper> getClassPaper(Integer classId,Integer type) {
       return   paperMapper.getClassPaper(classId,type);
    }

    @Override
    public Integer getStuPaperState(Integer paperId, String username) {
         return paperMapper.getStuPaperState(paperId,username);
    }

    @Override
    public List<Paper> getTestAndExam(Integer classId) {
        return paperMapper.getTestAndExam(classId);
    }


}
