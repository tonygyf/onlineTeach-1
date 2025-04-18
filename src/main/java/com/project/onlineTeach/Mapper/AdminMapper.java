package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Admin;
import com.project.onlineTeach.entity.Course;
import com.project.onlineTeach.entity.Student;
import com.project.onlineTeach.entity.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Insert("insert into admin (sex,job,accId) values (#{sex},#{job},#{accId})")
    public void newAdmin(Admin admin);
    @Select("select  * from where adminId=#{adminId}")
    Admin getInfo(Integer adminId);
    @Select("select  * from student")
    List<Student> getStu();
    @Delete("delete from xuanxiu where stuId=#{stuId}")
    void delFromXuanxiu(String stuId);
    @Delete("delete from student where stuId=#{stuId}")
    void delFromStu(String stuId);
    @Delete("delete from ansrecord where stuId=#{stuId}")
    void delFromAnsRecord(String stuId);
    @Delete("delete from examrecord where stuId=#{stuId}")
    void delFromExamRecord(String stuId);
    @Select("SELECT * FROM teacher")
    List<Teacher> getTea();
    @Select("SELECT * FROM course")
    List<Course> getCourse();
}
