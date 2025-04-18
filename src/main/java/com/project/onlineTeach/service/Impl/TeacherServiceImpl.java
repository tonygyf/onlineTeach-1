package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.TeacherMapper;
import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.Teacher;
import com.project.onlineTeach.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
   private TeacherMapper teacherMapper;

    @Override
    public void newInfo(Teacher teacher) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer accId = (Integer) map.get("id");
        String teaId=(String)map.get("username");
        teacherMapper.newInfo(teacher,accId,teaId);
    }

    @Override
    public void updateInfo(Teacher teacher) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String teaId=(String)map.get("username");
        teacherMapper.updateInfo(teacher,teaId);
    }

    @Override
    public Teacher findById(String teaId) {
        return  teacherMapper.findById(teaId);

    }

    @Override
    public void deleteById(String teaId) {
        teacherMapper.deleteById(teaId);
    }
}
