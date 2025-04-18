package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("insert into  student(stuId,stuName,sex,type,dept,major,grade,adminClass,accId) values (#{stuId},#{stu.stuName},#{stu.sex},#{stu.type},#{stu.dept},#{stu.major},#{stu.grade},#{stu.adminClass},#{accId})")
    void newInfo(Student stu,Integer accId,String stuId);
    @Update("update student set  stuName=#{stu.stuName},sex=#{stu.sex},type=#{stu.type},dept=#{stu.dept},major=#{stu.major},grade=#{stu.grade},adminClass=#{stu.adminClass} where stuId=#{stuId}")
    void updateInfo(Student stu, String stuId);
    @Select("select * from student where stuId=#{stuId}")
    Student findById(String stuId);
    @Delete("delete from student where stuId=#{stuId}")
    void deleteById(String stuId);
@Select("select student.stuId, stuname, sex, type, dept, major, grade, adminclass, accid, score from student ,xuanxiu where xuanxiu.stuId=student.stuId and classId=#{classId}")
    List<Student> getAllStu(String classId );
}
