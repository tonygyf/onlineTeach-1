package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Judge;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.JudgeService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    private JudgeService judgeService;
    @GetMapping("/info")
    public Result getInfo(@RequestParam Integer judgeId){
       Judge judge= judgeService.getInfo(judgeId);
        return Result.success(judge);
    }
    @GetMapping("/getInfo")
    public  Result getJudge(@RequestParam Integer exeId){
        Judge judge=judgeService.getJudge(exeId);
        return Result.success(judge);
    }
    @PostMapping("/add")
    public  Result addJudge(@RequestBody Judge judge){
            judgeService.addJudge(judge)      ;
            return  Result.success();
    }
    @PutMapping("/update")
    public  Result updateJudge(@RequestBody Judge judge){
        judgeService.updateJudge(judge);
        return  Result.success();
    }
    @DeleteMapping("/del")
    public Result delJudge(@RequestParam Integer judgeId,Integer exeId){
        judgeService.delJudge(judgeId,exeId);
        return Result.success();
    }

}
