package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.ShortAns;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ShortAnsMapper {
    @Select("select * from shortans where shortAnsId=#{shortAnsId}")
    ShortAns getInfo(Integer shortAnsId);
    @Insert("INSERT  INTO shortans(exeId,question,ans,ansText)  values (#{exeId},#{question},#{ans},#{ansText})")
    void addShortAns(ShortAns shortAns);
@Delete("DELETE  FROM shortans where shortAnsId=#{shortAnsId}")
    void delShortAns(Integer shortAnsId);
@Update("update shortans set question=#{question}, ans=#{ans}, ansText=#{ansText} where shortAnsId=#{shortAnsId}")
    void updateShortAns(ShortAns shortAns);
@Select("select* from shortans where exeId=#{exeId}")
    ShortAns getShortAns(Integer exeId);
}
