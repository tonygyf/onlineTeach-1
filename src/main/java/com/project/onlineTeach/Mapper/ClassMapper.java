package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.Controller.ClassController;
import com.project.onlineTeach.entity.Class;
import com.project.onlineTeach.entity.Xuanxiu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper {
     @Select("select  * from class where classId=#{classId}")
    Class getClassInfo(Integer classId);
    @Insert("insert into class values (#{classId},#{stuNum},#{courseId},#{teaId},#{logo})")
    void addClass(Class newClass);
    @Delete("delete from class where classId=#{classId}")
    void delClass(Integer classId);
    @Insert("insert into xuanxiu values (#{stuId},#{classId},0)")
    void addStuToClass(String stuId, Integer classId);
    @Update("update xuanxiu set score=#{score} where stuId=#{stuId} and classId=#{classId}")
    void giveFinalScore(Integer score,String stuId,Integer classId);

    @Insert({
            "<script>",
            "insert into xuanxiu (stuId, classId, score) values ",
            "<foreach collection='studentClasses' item='studentClass' separator=','>",
            "(#{studentClass.stuId}, #{studentClass.classId}, 0)",
            "</foreach>",
            "</script>"
    })
    void batchAddStudentsToClass(@Param("studentClasses") List<Xuanxiu> studentClasses);
    @Select("select * from class ,course where class.courseId=course.courseId and classId in( select xuanxiu.classId from xuanxiu where stuId=#{stuId})")

    List<ClassController.ClassAndCourse> getAllClass(String stuId);
    @Select("select score from xuanxiu where stuId=#{stuId} and classId=#{classId}")
    Integer getSummaryScore(String stuId, Integer classId);
    @Select("select * from class ,course where class.courseId=course.courseId and teaId=#{teaId}")
    List<ClassController.ClassAndCourse> teaGetClass(String teaId);
    @Delete("delete from xuanxiu where stuId=#{stuId} and classId=#{classId}")
    void delFormClass(String stuId, Integer classId);
@Select("update class set stuNum=( select count(*) from xuanxiu where classId=#{classId}) where classId=#{classId}")
    Integer getNumber(Integer classId);
}
