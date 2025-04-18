package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Controller.ExamController;
import com.project.onlineTeach.Mapper.ExamMapper;
import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.ExamRecord;
import com.project.onlineTeach.entity.Paper;
import com.project.onlineTeach.service.AnswerService;
import com.project.onlineTeach.service.ExamService;
import com.project.onlineTeach.service.MakePaperService;
import com.project.onlineTeach.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private PaperService paperService;
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private AnswerService answerService;
    @Override
    public void giveScore(Integer score,String stuId, Integer paperId) {

     Paper paper=   paperService.getInfo(paperId);
     Integer standardScore=paper.getStandardScore();
     Boolean isPass =false;
     if(score>standardScore)isPass=true;
        examMapper.giveScore(score,stuId,paperId,isPass);
    }

    @Override
    public void addRecord( Integer paperId,Integer time) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String stuId=(String)map.get("username");
        examMapper.addRecord(stuId,paperId,time);
    }

    @Override
    public ExamRecord getInfo(String stuId, Integer paperId) {
       return   examMapper.getInfo(stuId,paperId);
    }

    @Override
    public List<ExamRecord> getSelfClassExam(String stuId, Integer classId) {
       return   examMapper.getSelfClassExam(stuId,classId);
    }

    @Override
    public ExamController.AnsAndMyRecord getAnsAndMyRecord(Integer paperExeId,Integer type) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String stuId=(String)map.get("username");
        if (type==0){
            //选择
            return examMapper.getAnsChooseAndMyRecord(paperExeId,stuId);

        }
        else if(type==1){
            //填空
            return examMapper.getAnsBlankAndMyRecord(paperExeId,stuId);

        }
        else if (type==2){
            //判断
            return examMapper.getAnsJudgeAndMyRecord(paperExeId,stuId);

        }
        else if (type==3){
            //简答
            return examMapper.getAnsShortAndMyRecord(paperExeId,stuId);

        }
        return null;
    }

    @Override
    public void getObjectScore(Integer paperId) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String stuId=(String)map.get("username");
        List<ExamController.AnsAndMyRecord>ansAndMyRecordList=   examMapper.getObjectScore(paperId,stuId);
        Integer tolScore=0;
        for (ExamController.AnsAndMyRecord ansAndMyRecord: ansAndMyRecordList){

            String realAns=ansAndMyRecord.getAns();
            String stuAns=ansAndMyRecord.getStuAns();
            Integer paperExeId=ansAndMyRecord.getPaperExeId();
            Integer score=0;
            Integer fullScore=ansAndMyRecord.getScore();
            if(stuAns.equals(realAns)){
                    score=fullScore;
            }
            tolScore+=score;
            answerService.updateScore(score,paperExeId,stuId);

        }
        giveScore(tolScore,stuId,paperId);
    }

    @Override
    public List<ExamRecord> getStuExamState(Integer paperId) {
        return examMapper.getStuExamState(paperId);
    }
}
