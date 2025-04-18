package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.*;
import com.project.onlineTeach.service.MakePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/makePaper")
public class MakePaperController {
    /**
     * 组卷
     */
    @Autowired
    private MakePaperService makePaperService;
    @PostMapping("/new")
    public Result  makeNewPaper(@RequestBody ExeAndPaper exeAndPaper){
                makePaperService.makeNewPaper(exeAndPaper.getPaperId(),exeAndPaper.getPaperExes());
                return Result.success();
    }
    @GetMapping("/info")
    public Result getPaperExe(@RequestParam Integer paperId){
       List<PaperExe>paperExes=   makePaperService.getInfo(paperId);
        return Result.success(paperExes);
    }
    @DeleteMapping("/del")
    public Result delPaperExe(@RequestParam Integer paperExeId){
        makePaperService.delPaperExe(paperExeId);
        return Result.success();
    }
    @PutMapping("/update")
    public Result updatePaperExe(@RequestParam Integer paperExeId, Integer score){
        makePaperService.updateScore(paperExeId,score);
        return Result.success();
    }
    @GetMapping("/getAllChoose")
    public  Result getAllChoose(@RequestParam Integer paperId){
        List<Choose> chooseList=makePaperService.getAllChoose(paperId);
        return Result.success(chooseList);
    }
    @GetMapping("/getAllBlank")
    public Result getAllBlank(@RequestParam Integer paperId){
        List<Blank>blankList=makePaperService.getAllBlank(paperId);
        return Result.success(blankList);
    }
    @GetMapping("/getAllJudge")
    public Result getAllJudge(@RequestParam Integer paperId)
    {
        List<Judge>judgeList=makePaperService.getAllJudge(paperId);
        return Result.success(judgeList);
    }
    @GetMapping("/getAllShortAns")
    public Result getAllShortAns(@RequestParam Integer paperId)
    {
        List<ShortAns> shortAnsList=makePaperService.getAllShortAns(paperId);
        return Result.success(shortAnsList);
    }

    static public class ExeAndPaper{
        private  Integer paperId;
        private List<PaperExe>paperExes;

        @Override
        public String toString() {
            return "exeAndPaper{" +
                    "paperId=" + paperId +
                    ", paperExes=" + paperExes +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ExeAndPaper that = (ExeAndPaper) o;
            return Objects.equals(paperId, that.paperId) && Objects.equals(paperExes, that.paperExes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(paperId, paperExes);
        }

        public Integer getPaperId() {
            return paperId;
        }

        public void setPaperId(Integer paperId) {
            this.paperId = paperId;
        }

        public List<PaperExe> getPaperExes() {
            return paperExes;
        }

        public void setPaperExes(List<PaperExe> paperExes) {
            this.paperExes = paperExes;
        }
    }
}
