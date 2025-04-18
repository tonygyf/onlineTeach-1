package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Choose;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ChoiceMapper {
    @Select("select  * from choose where chooseId=#{chooseId}")
    Choose choiceInfo(Integer chooseId);
    @Insert("insert into choose(exeId,question,ans,optionA,optionB,optionC,optionD,ansText) values (#{exeId},#{question},#{ans},#{optionA},#{optionB},#{optionC},#{optionD},#{ansText})")
    void newChoice(Choose choose);
    @Delete("delete from choose where chooseId=#{chooseId}")
    void delChoice(Integer chooseId);
    @Update("update choose set question=#{question},ans=#{ans},optionA=#{optionA},optionB=#{optionB},optionC=#{optionC},optionD=#{optionD},ansText=#{ansText} where chooseId=#{chooseId}")
    void updateChoice(Choose choose);
    @Select("select * from choose where exeId=#{exeId}")
    Choose getChoose(Integer exeId);
}
