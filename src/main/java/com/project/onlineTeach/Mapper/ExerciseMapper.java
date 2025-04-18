package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.Controller.ExerciseController;
import com.project.onlineTeach.entity.Exercise;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    @Insert("insert into   exercise (exeId,type,updateTime,classId) values (#{exeId},#{type},now(),#{classId})")
    void newExe(Integer exeId,String type,Integer classId);
    @Delete("delete  from exercise where exeId=#{exeId}")
    void delExe(Integer exeId);
    @Select("select * from exercise where exeId=#{exeId}")
    Exercise exeInfo(Integer exeId);
    @Select("select * from ((select exercise.exeId, type, question, ans, ansText,classId from exercise, choose  where choose.exeId = exercise.exeId)  union (select exercise.exeId, type,question,ans,ansText,classId from exercise , blank where blank.exeId=exercise.exeId) union (select exercise.exeId, type,question,ans,ansText,classId from exercise,judge where exercise.exeId  = judge.exeId) union(select exercise.exeId, type,question,ans,ansText,classId  from exercise, shortans where  exercise.exeId=shortans.exeId )) as eceb  where classId=#{classId} order by exeId")
    List<ExerciseController.ClassExe> getClassExe(Integer classId);
}
