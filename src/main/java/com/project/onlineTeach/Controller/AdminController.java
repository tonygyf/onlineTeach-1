package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.*;
import com.project.onlineTeach.service.AccountService;
import com.project.onlineTeach.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AccountService accountService;
    @PostMapping("/new")
    public Result newAdmin(@RequestBody Admin admin){
        /**
         * 新增管理员
         */
        adminService.newAdmin(admin);
        return Result.success();
    }
    @GetMapping("/info")
    public Result getInfo(@RequestParam Integer adminId)
    {
        /**
         * 获取管理员个人信息
         */
       Admin admin= adminService.getInfo(adminId);
        return Result.success(admin);
    }
    @GetMapping("/getStu")
    public  Result getStu(){
        /**
         * 管理员获取学生列表
         */
        List<Student> studentList=adminService.getStu();
        return Result.success(studentList);
    }
    @GetMapping("/getTea")
    public Result getTea(){
        /**
         * 管理员获取教师列表
         */
        List<Teacher>teacherList=adminService.getTea();
        return Result.success(teacherList);
    }
    @DeleteMapping("/delStu")
    public Result delStu(@RequestParam String stuId,Integer accId){
        /**
         * 管理员删除学生
         */
        adminService.delFromXuanxiu(stuId);
        adminService.delFromStu(stuId);
        adminService.delFromAnsRecord(stuId);
        adminService.delFromExamRecord(stuId);
        accountService.deleteById(accId);
      return   Result.success();
    }
  @GetMapping("/getCourse")
    public Result getCourse()
  {
      /**
       * 管理员获取课程列表
       */
      List<Course>courseList=adminService.getCourse();
      return Result.success(courseList);
  }
}
