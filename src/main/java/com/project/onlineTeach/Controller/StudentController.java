package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.entity.Student;
import com.project.onlineTeach.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/newInfo")
    public Result newInfo(@Validated @RequestBody Student stu){
            studentService.newInfo(stu);
            return Result.success();
    }
    @PutMapping("/updateInfo")
    public Result updateInfo(@Validated @RequestBody Student stu){
        studentService.updateInfo(stu);
        return Result.success();
    }
    @GetMapping("/search")
    public Result findById(@RequestParam String stuId){
       Student student= studentService.findById(stuId);
        return Result.success(student);
    }

    @DeleteMapping("/delete")
    public Result deleteById(@RequestParam String stuId){
        studentService.deleteById(stuId);
        return  Result.success();
    }
    @GetMapping("/getAllStu")
    public Result getAllStu(@RequestParam String classId){
      List<Student>studentList=  studentService.getAllStu(classId);
        return Result.success(studentList);
    }

}
