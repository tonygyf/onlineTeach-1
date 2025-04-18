package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.entity.Student;
import com.project.onlineTeach.entity.Teacher;
import com.project.onlineTeach.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")

public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping("/newInfo")
    public Result newInfo(@Validated @RequestBody Teacher teacher){
        teacherService.newInfo(teacher);
        return Result.success();
    }
    @PutMapping("/updateInfo")
    public Result updateInfo(@Validated @RequestBody Teacher teacher){
        teacherService.updateInfo(teacher);
        return Result.success();
    }
    @GetMapping("/search")
    public Result findById(@RequestParam String teaId){
        Teacher teacher= teacherService.findById(teaId);
        return Result.success(teacher);
    }
    @DeleteMapping("/delete")
    public Result deleteById(@RequestParam String teaId){
        teacherService.deleteById(teaId);
        return Result.success();
    }
}
