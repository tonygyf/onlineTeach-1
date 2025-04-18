package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Blank;
import com.project.onlineTeach.service.BlankService;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BlankMapper {
    @Insert("insert  into blank (exeId,question,ans,ansText) values (#{exeId},#{question},#{ans},#{ansText})")
    void addBlank(Blank blank);
    @Select("select * from blank where blankId=#{blankId}")
    Blank getInfo(Integer blankId);
    @Update("UPDATE blank set question=#{question}, ans=#{ans},ansText=#{ansText} where blankId=#{blankId}")
    void updateBlank(Blank blank);
    @Delete("delete  from blank where blankId=#{blankId}")
    void delBlank(Integer blankId);
    @Select("select  * from blank where exeId=#{exeId}")
    Blank getBlank(Integer exeId);
}
