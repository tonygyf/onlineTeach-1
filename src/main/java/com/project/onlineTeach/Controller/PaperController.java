package com.project.onlineTeach.Controller;

import cn.hutool.core.date.DateTime;
import com.project.onlineTeach.entity.Paper;
import com.project.onlineTeach.entity.PaperExe;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;
    @PostMapping("/new")
    public Result newPaper(@RequestBody Paper paper){
        paperService.newPaper(paper);
        return Result.success();
    }
    @GetMapping("/info")
    public Result getInfo(@RequestParam Integer paperId){

        Paper paper= paperService.getInfo(paperId);
        return Result.success(paper);
    }
    @PutMapping("/update")
    public Result updatePaper(@RequestBody Paper paper){
        paperService.updatePaper(paper);
        return Result.success();
    }
    @DeleteMapping("/del")
    public Result delPaper(@RequestParam Integer paperId){
        paperService.delPaper(paperId);
        return Result.success();
    }
    @GetMapping("/class")
    public Result getClassPaper(@RequestParam Integer classId,Integer type){
      List<Paper> paperList= paperService.getClassPaper(classId,type);
        return Result.success(paperList);
    }
    @GetMapping("/testAndExam")
    public Result getTestAndExam(@RequestParam Integer classId ){
        List<Paper>paperList=paperService.getTestAndExam(classId);
        return Result.success(paperList);
    }
    @GetMapping("/getState")
    public Result getStuPaperState(@RequestParam Integer paperId, String username){
       Integer state= paperService.getStuPaperState(paperId,username);
        return Result.success(state);
    }

}
