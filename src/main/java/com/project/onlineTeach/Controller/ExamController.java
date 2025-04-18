package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.AnsRecord;
import com.project.onlineTeach.entity.ExamRecord;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;
    @PostMapping("/score")
    public Result giveScore(@RequestParam Integer score, String stuId, Integer paperId){
        /**
         * 老师阅卷给出考试分数
         */
        examService.giveScore(score,stuId,paperId);
        return Result.success();

    }
    @PostMapping("/addRecord")
    public  Result addRecord(@RequestParam  Integer paperId,Integer time){
        /**
         * 新增考试记录
         */
        examService.addRecord( paperId,time);
        return Result.success();
    }
    @GetMapping("/singleExam")
    public Result getInfo(@RequestParam String stuId,Integer paperId){
        /**
         * 获取单条考试记录
         */
      ExamRecord examRecord= examService.getInfo(stuId,paperId);
        return Result.success(examRecord);
    }
    @GetMapping("/selfExam")
    public Result getSelfClassExam(@RequestParam String stuId, Integer classId){
        /**
         * 获取个人班级内考试记录
         */
      List<ExamRecord> examRecordList= examService.getSelfClassExam(stuId,classId);
      return Result.success(examRecordList);
    }
    @GetMapping("/getAnsAndMyRecord")
    public Result getAnsAndMyRecord(@RequestParam Integer paperExeId,Integer type){
        /**
         * 获取我的答案和正确答案
         */
        AnsAndMyRecord ansAndMyRecord= examService.getAnsAndMyRecord(paperExeId,type);
return Result.success(ansAndMyRecord);
    }
@GetMapping("/getObjectScore")
public Result getObjectScore (@RequestParam Integer paperId){
    /**
     * 客观题自动阅卷
     */
    examService.getObjectScore(paperId);
      return Result.success();
}
@GetMapping("/getStuExamState")
public Result getStuExamState(@RequestParam Integer paperId){
    /**
     * 获取学生考试成绩
     */
    List<ExamRecord> examRecordList=  examService.getStuExamState(paperId);
      return Result.success(examRecordList);
}
    static public class AnsAndMyRecord{
        private Integer paperExeId;
        private Integer score;
        private String  stuAns;
       private Integer stuScore;
      private   String  ans;
      private String  ansText;

        @Override
        public String toString() {
            return "AnsAndMyRecord{" +
                    "paperExeId=" + paperExeId +
                    ", score=" + score +
                    ", stuAns='" + stuAns + '\'' +
                    ", stuScore=" + stuScore +
                    ", ans='" + ans + '\'' +
                    ", ansText='" + ansText + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AnsAndMyRecord that = (AnsAndMyRecord) o;
            return Objects.equals(paperExeId, that.paperExeId) && Objects.equals(score, that.score) && Objects.equals(stuAns, that.stuAns) && Objects.equals(stuScore, that.stuScore) && Objects.equals(ans, that.ans) && Objects.equals(ansText, that.ansText);
        }

        @Override
        public int hashCode() {
            return Objects.hash(paperExeId, score, stuAns, stuScore, ans, ansText);
        }

        public Integer getPaperExeId() {
            return paperExeId;
        }

        public void setPaperExeId(Integer paperExeId) {
            this.paperExeId = paperExeId;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public String getStuAns() {
            return stuAns;
        }

        public void setStuAns(String stuAns) {
            this.stuAns = stuAns;
        }

        public Integer getStuScore() {
            return stuScore;
        }

        public void setStuScore(Integer stuScore) {
            this.stuScore = stuScore;
        }

        public String getAns() {
            return ans;
        }

        public void setAns(String ans) {
            this.ans = ans;
        }

        public String getAnsText() {
            return ansText;
        }

        public void setAnsText(String ansText) {
            this.ansText = ansText;
        }
    }}
