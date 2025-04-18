package com.project.onlineTeach.Controller;

import cn.hutool.core.date.DateTime;
import com.project.onlineTeach.entity.Exercise;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/exe")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;
    @PostMapping("/add")
    public Result newExe(@RequestParam Integer exeId,String type,Integer classId){
        Exercise exercise=exerciseService.exeInfo(exeId);
        if(exercise==null){
        exerciseService.newExe(exeId,type,classId);
        return Result.success();}
        else {
            return Result.error("题目编号重复，请重新输入");
        }
    }

    @GetMapping("/info")
    public Result exeInfo(@RequestParam Integer exeId){
       Exercise exercise= exerciseService.exeInfo(exeId);
        return Result.success(exercise);
    }
    @GetMapping("/getClassExe")
    public Result getClassEXE(@RequestParam Integer classId){
        /**
         * 获取班级全部练习
         */
       List<ClassExe> classExeList= exerciseService.getClassExe(classId);
       return Result.success(classExeList);
    }
    static public  class ClassExe {
        Integer exeId;
        String type;
        String question;
        String ans;
        String ansText;
        Integer classId;
        Boolean popVisible=false;

        @Override
        public String toString() {
            return "ClassExe{" +
                    "exeId=" + exeId +
                    ", type='" + type + '\'' +
                    ", question='" + question + '\'' +
                    ", ans='" + ans + '\'' +
                    ", ansText='" + ansText + '\'' +
                    ", classId=" + classId +
                    ", popVisible=" + false +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClassExe classExe = (ClassExe) o;
            return Objects.equals(exeId, classExe.exeId) && Objects.equals(type, classExe.type) && Objects.equals(question, classExe.question) && Objects.equals(ans, classExe.ans) && Objects.equals(ansText, classExe.ansText) && Objects.equals(classId, classExe.classId) && Objects.equals(popVisible, classExe.popVisible);
        }

        @Override
        public int hashCode() {
            return Objects.hash(exeId, type, question, ans, ansText, classId, popVisible);
        }

        public Integer getExeId() {
            return exeId;
        }

        public void setExeId(Integer exeId) {
            this.exeId = exeId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
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

        public Integer getClassId() {
            return classId;
        }

        public void setClassId(Integer classId) {
            this.classId = classId;
        }

        public Boolean getPopVisible() {
            return popVisible;
        }

        public void setPopVisible(Boolean popVisible) {
            this.popVisible = popVisible;
        }
    }
}
