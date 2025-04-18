package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherMapper {
    @Insert("insert into teacher values (#{teaId},#{teacher.teaName},#{teacher.sex},#{teacher.phone},#{teacher.email},#{teacher.job},#{teacher.courses},#{teacher.selfInfo},#{accId})")
    void newInfo(Teacher teacher, Integer accId, String teaId);
    @Update("update teacher set teaName=#{teacher.teaName},sex=#{teacher.sex},phone=#{teacher.phone},email=#{teacher.email},job=#{teacher.job},courses=#{teacher.courses},selfInfo=#{teacher.selfInfo} where teaId=#{teaId}")
    void updateInfo(Teacher teacher, String teaId);
@Select("select * from teacher where teaId=#{teaId}")
    Teacher findById(String teaId);
@Delete("delete from teacher where teaId=#{teaId}")
    void deleteById(String teaId);
}
