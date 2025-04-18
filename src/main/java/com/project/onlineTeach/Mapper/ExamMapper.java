package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.Controller.ExamController;
import com.project.onlineTeach.entity.ExamRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ExamMapper {
    @Update("update  examrecord set score=#{score}, state=#{isPass} where stuId=#{stuId} and paperId=#{paperId}")
    void giveScore(Integer score,String stuId,Integer paperId,Boolean isPass);
    @Insert("insert into examrecord (stuId,paperId,time,score,state) values (#{stuId},#{paperId},#{time},0,0)")
    void addRecord(String stuId, Integer paperId,Integer time);
    @Select("select  * from examrecord where stuId=#{stuId} and paperId=#{paperId}")
    ExamRecord getInfo(String stuId, Integer paperId);
    @Select("select  * from examrecord , paper where examrecord.paperId=paper.paperId and classId=#{classId} and stuId=#{stuId}")
    List<ExamRecord> getSelfClassExam(String stuId, Integer classId);

    @Select("select paperexe.paperExeId,score,stuAns,stuScore,ans,ansText from ansrecord ,paperexe,exercise,choose where exercise.exeId=paperexe.exeId and ansrecord.paperExeId=paperexe.paperExeId and choose.exeId=exercise.exeId and type='选择题' and paperexe.paperExeId=#{paperExeId} and stuId=#{stuId}")
    ExamController.AnsAndMyRecord getAnsChooseAndMyRecord(Integer paperExeId,String stuId);
    @Select("select paperexe.paperExeId,score,stuAns,stuScore,ans,ansText from ansrecord ,paperexe,exercise,judge where exercise.exeId=paperexe.exeId and ansrecord.paperExeId=paperexe.paperExeId and judge.exeId=exercise.exeId and type='判断题' and paperexe.paperExeId=#{paperExeId} and stuId=#{stuId}")

    ExamController.AnsAndMyRecord getAnsJudgeAndMyRecord(Integer paperExeId,String stuId);
    @Select("select paperexe.paperExeId,score,stuAns,stuScore,ans,ansText from ansrecord ,paperexe,exercise,blank where exercise.exeId=paperexe.exeId and ansrecord.paperExeId=paperexe.paperExeId and blank.exeId=exercise.exeId and type='填空题' and paperexe.paperExeId=#{paperExeId} and stuId=#{stuId}" )

    ExamController.AnsAndMyRecord getAnsBlankAndMyRecord(Integer paperExeId,String stuId);
    @Select("select paperexe.paperExeId,score,stuAns,stuScore,ans,ansText from ansrecord ,paperexe,exercise,shortans where exercise.exeId=paperexe.exeId and ansrecord.paperExeId=paperexe.paperExeId and shortans.exeId=exercise.exeId and type='简答题' and paperexe.paperExeId=#{paperExeId} and stuId=#{stuId}")

    ExamController.AnsAndMyRecord getAnsShortAndMyRecord(Integer paperExeId,String stuId);
    @Select("select paperexe.score,paperexe.paperExeId,ans,stuAns from paperexe, ((select exeId ,ans from choose)   union (select exeId ,ans from blank) union (select exeId,ans from judge) union (select exeId,ans from shortans) )ExeAndAns,ansrecord where paperexe.paperExeId=ansrecord.paperExeId and paperexe.exeId=ExeAndAns.exeId and paperId=#{paperId} and stuId=#{stuId}")
    List<ExamController.AnsAndMyRecord> getObjectScore(Integer paperId, String stuId);
    @Select("select * from examrecord where paperId=#{paperId}")
    List<ExamRecord> getStuExamState(Integer paperId);
}
