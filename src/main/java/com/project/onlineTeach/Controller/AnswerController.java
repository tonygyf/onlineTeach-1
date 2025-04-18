package com.project.onlineTeach.Controller;

import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.AnsRecord;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/ans")
public class AnswerController {
        @Autowired
        private AnswerService answerService;

    @PostMapping("/newAns")
    public Result newAns(@RequestBody SubmitRequest submitRequest) {
        /**
         * 新增作答记录
         */
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        answerService.newAns(username,submitRequest.getAnswers());
        return Result.success();
    }

    static class SubmitRequest {

        private List<AnsRecord> answers;



        public List<AnsRecord> getAnswers() {
            return answers;
        }

        public void setAnswers(List<AnsRecord> answers) {
            this.answers = answers;
        }
    }
}
