package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Choose;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.entity.ShortAns;
import com.project.onlineTeach.service.ShortAnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shortAns")
public class ShortAnsController {
    @Autowired
    private   ShortAnsService shortAnsService;
    @GetMapping("/info")
    public Result getInfo(@RequestParam Integer shortAnsId){
        ShortAns shortAns=   shortAnsService.getInfo(shortAnsId);
        return Result.success(shortAns);
    }
    @GetMapping("/getInfo")
    public  Result getShortAns(@RequestParam Integer exeId ){
        ShortAns shortAns=shortAnsService.getShortAns(exeId);
        return Result.success(shortAns);
    }
    @PostMapping("/add")
    public Result newChoice(@Validated @RequestBody ShortAns shortAns){
        shortAnsService.addShortAns(shortAns);
        return  Result.success();
    }
    @DeleteMapping("/del")
    public  Result delChoice(@RequestParam Integer shortAnsId,Integer exeId){
        shortAnsService.delShortAns(shortAnsId,exeId);
        return Result.success();
    }
    @PutMapping("/update")
    public  Result updateChoice(@RequestBody ShortAns shortAns){
        shortAnsService.updateShortAns(shortAns);
        return Result.success();
    }
}
