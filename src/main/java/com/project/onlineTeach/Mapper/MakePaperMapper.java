package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MakePaperMapper {
    @Insert({
            "<script>",
            "insert into paperexe (paperId, exeId, score) values ",
            "<foreach collection='paperExes' item='paperExe' separator=','>",
            "(#{paperExe.paperId}, #{paperExe.exeId}, #{paperExe.score})",
            "</foreach>",
            "</script>"
    })
    void makeNewPaper(List<PaperExe> paperExes);

    @Select("select * from paperexe where paperId=#{paperId}")
    List<PaperExe> getInfo(Integer paperId);
    @Delete("delete from paperexe where paperExeId=#{paperExeId}")
    void delPaperExe(Integer paperExeId);
    @Update("update paperexe set score=#{score} where paperExeId=#{paperExeId}")
    void updateScore(Integer paperExeId, Integer score);
    @Select("select paperExeId,chooseId,exercise.exeId,question,optionA,optionB,optionC,optionD,score from paperexe, exercise,choose  where exercise.exeId=paperexe.exeId and exercise.exeId=choose.exeId and paperId=#{paperId} order by paperId")
    List<Choose> getAllChoose(Integer paperId);
    @Select("select paperExeId,exercise.exeId,blankId,question,score from paperexe, exercise,blank  where exercise.exeId=paperexe.exeId and exercise.exeId=blank.exeId and paperId=#{paperId} order by paperId")
    List<Blank> getAllBlank(Integer paperId);
    @Select("select paperExeId,exercise.exeId,judgeId,question,score from paperexe, exercise,judge  where exercise.exeId=paperexe.exeId and exercise.exeId=judge.exeId and paperId=#{paperId} order by paperId")
    List<Judge> getAllJudge(Integer paperId);
    @Select("select paperExeId,exercise.exeId,shortAnsId,question,score from paperexe, exercise,shortans  where exercise.exeId=paperexe.exeId and exercise.exeId=shortans.exeId and paperId=#{paperId} order by paperId ")
    List<ShortAns> getAllShortAns(Integer paperId);
    @Delete("delete from paperexe where  exeId=#{exeId}")
    void delByExeId(Integer exeId);
}
