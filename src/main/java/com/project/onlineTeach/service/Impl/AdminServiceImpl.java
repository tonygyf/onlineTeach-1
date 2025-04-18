package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.AdminMapper;
import com.project.onlineTeach.entity.Admin;
import com.project.onlineTeach.entity.Course;
import com.project.onlineTeach.entity.Student;
import com.project.onlineTeach.entity.Teacher;
import com.project.onlineTeach.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void newAdmin(Admin admin) {
        adminMapper.newAdmin(admin);
    }

    @Override
    public Admin getInfo(Integer adminId) {
      return   adminMapper.getInfo(adminId);
    }

    @Override
    public List<Student> getStu() {
        return adminMapper.getStu();
    }

    @Override
    public void delFromXuanxiu(String stuId) {
        adminMapper.delFromXuanxiu(stuId);
    }

    @Override
    public void delFromStu(String stuId) {
adminMapper.delFromStu(stuId);
    }

    @Override
    public void delFromAnsRecord(String stuId) {
adminMapper.delFromAnsRecord(stuId);
    }

    @Override
    public void delFromExamRecord(String stuId) {
adminMapper.delFromExamRecord(stuId);
    }

    @Override
    public List<Teacher> getTea() {
        return adminMapper.getTea();
    }

    @Override
    public List<Course> getCourse() {
        return adminMapper.getCourse();
    }
}
