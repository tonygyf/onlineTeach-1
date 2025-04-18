package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Blank;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.BlankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blank")
public class BlankController {
    @Autowired
    private BlankService blankService;
    @PostMapping("/add")
    public Result addBlank(@Validated @RequestBody Blank blank){
        blankService.addBlank(blank);
        return  Result.success();
    }
    @GetMapping("/getInfo")
    public Result getBlank(@RequestParam Integer exeId){
     Blank blank=   blankService.getBlank(exeId);
     return Result.success(blank);
    }
    @GetMapping("/info")
    public Result getInfo(@RequestParam Integer blankId)
    {
      Blank blank=  blankService.getInfo(blankId);
        return Result.success(blank);
    }
    @PutMapping("/update")
    public Result updateBlank(@RequestBody Blank blank){
        blankService.updateBlank(blank);
        return Result.success();
    }
    @DeleteMapping("/del")
    public  Result delBlank(@RequestParam Integer blankId,Integer exeId){
        blankService.delBlank(blankId,exeId);
        return Result.success();
    }
}
