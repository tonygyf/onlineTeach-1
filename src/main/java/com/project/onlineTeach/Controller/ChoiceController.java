package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Choose;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/choice")

public class ChoiceController {
    @Autowired
    private ChoiceService choiceService;
    @GetMapping("/info")
    public Result choiceInfo(@RequestParam Integer chooseId){
      Choose choose=   choiceService.choiceInfo(chooseId);
      return Result.success(choose);
    }
    @GetMapping("/getInfo")
    public Result getChoose(@RequestParam Integer exeId){
        Choose choose=choiceService.getChoose(exeId);
        return Result.success(choose);
    }
    @PostMapping("/add")
    public Result newChoice(@Validated @RequestBody Choose choose){
        choiceService.newChoice(choose);
        return  Result.success();
    }
    @DeleteMapping("/del")
    public  Result delChoice(@RequestParam Integer chooseId,Integer exeId){
        choiceService.delChoice(chooseId,exeId);
        return Result.success();
    }
    @PutMapping("/update")
    public  Result updateChoice(@RequestBody Choose choose){
        choiceService.updateChoice(choose);
        return Result.success();
    }
}
