package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Paper;
import com.project.onlineTeach.entity.PaperExe;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaperMapper {

    @Insert("insert into paper(type,tolScore,standardScore,startTime,endTime,updateTime,state,duration,classId,paperTitle) values (#{paper.type},#{paper.tolScore},#{paper.standardScore},#{paper.startTime},#{paper.endTime},now(),#{paper.state},#{duration},#{paper.classId},#{paper.paperTitle})")
    void newPaper(Paper paper,Integer duration);
@Select("select  * from paper where paperId=#{paperId}")
    Paper getInfo(Integer paperId);
@Update("update paper set type=#{paper.type},tolScore=#{paper.tolScore},standardScore=#{paper.standardScore},startTime=#{paper.startTime},endTime=#{paper.endTime},updateTime=now(),state=#{paper.state},duration=#{duration},paperTitle=#{paperTitle}")
    void updatePaper(Paper paper,Integer duration);
@Delete("delete from paper where paperId=#{paperId}")
    void delPaper(Integer paperId);
@Select("select * from paper where classId=#{classId} and type=#{type}")
List<Paper> getClassPaper(Integer classId,Integer type);
@Select("SELECT state from examrecord where  paperId=#{paperId} and stuId=#{username}")
    Integer getStuPaperState(Integer paperId, String username);
@Select("SELECT * from paper where classId=#{classId}")
    List<Paper> getTestAndExam(Integer classId);
}
