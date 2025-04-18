package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.entity.Slides;
import com.project.onlineTeach.service.SlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slides")
public class SlidesController {
    @Autowired
    private SlidesService slidesService;
    @PostMapping("/add")
    public Result addSlide(@RequestBody Slides slides){
        slidesService.addSlide(slides);
        return Result.success();

    }
    @DeleteMapping("/del")
    public Result delSlide(@RequestParam Integer slidesId){
        slidesService.delSlide(slidesId);
        return Result.success();
    }
    @PutMapping("/update")
    public Result updateSlide(@RequestBody Slides slides){
        slidesService.updateSlide(slides);
        return  Result.success();
    }
    @GetMapping("/info")
    public Result getSlide(@RequestParam Integer slidesId){
       Slides slides= slidesService.getSlide(slidesId);
        return Result.success(slides);
    }
    @GetMapping("/getSlides")
    public  Result getSlides(@RequestParam String courseId){
        List<Slides> slidesList=slidesService.getSlides(courseId);
        return Result.success(slidesList);
    }

}
