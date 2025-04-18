package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.StudentMapper;
import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.Student;
import com.project.onlineTeach.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void newInfo(Student stu ) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer accId = (Integer) map.get("id");
        String stuId=(String)map.get("username");
        studentMapper.newInfo(stu,accId,stuId);
    }

    @Override
    public void updateInfo(Student stu) {
        Map<String, Object> map = ThreadLocalUtil.get();
         String stuId=(String)map.get("username");
        studentMapper.updateInfo(stu,stuId);
    }

    @Override
    public Student findById(String stuId) {
       return  studentMapper.findById(stuId);
    }

    @Override
    public void deleteById(String stuId) {
        studentMapper.deleteById(stuId);
    }

    @Override
    public List<Student> getAllStu(String classId) {


        return studentMapper.getAllStu(classId );
    }
}
