package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Judge;
import org.apache.ibatis.annotations.*;

@Mapper
public interface JudgeMapper {
    @Select("select  * from judge where judgeId=#{judgeId}")
    Judge getInfo(Integer judgeId);
    @Delete("delete  from judge where judgeId=#{judgeId}")
    void delJudge(Integer judgeId);
    @Update("update judge set question=#{question} ,ans=#{ans},ansText=#{ansText} where judgeId=#{judgeId}")
    void updateJudge(Judge judge);
    @Insert("insert into  judge (exeId,question,ans,ansText) values (#{exeId},#{question},#{ans},#{ansText})")
    void addJudge(Judge judge);
    @Select("SELECT * FROM judge where exeId=#{exeId}")
    Judge getJudge(Integer exeId);
}
