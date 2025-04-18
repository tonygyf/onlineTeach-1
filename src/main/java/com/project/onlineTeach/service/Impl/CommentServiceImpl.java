package com.project.onlineTeach.service.Impl;

import cn.hutool.core.date.DateTime;
import com.project.onlineTeach.Controller.CommentController;
import com.project.onlineTeach.Mapper.CommentMapper;
import com.project.onlineTeach.Util.ThreadLocalUtil;
import com.project.onlineTeach.entity.Account;
import com.project.onlineTeach.entity.Comment;
import com.project.onlineTeach.entity.Student;
import com.project.onlineTeach.entity.Teacher;
import com.project.onlineTeach.service.AccountService;
import com.project.onlineTeach.service.CommentService;
import com.project.onlineTeach.service.StudentService;
import com.project.onlineTeach.service.TeacherService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
   private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AccountService accountService;
    @Override
    public void newComment(Comment comment) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        Account account= accountService.findByUsername(username);
         Integer accType=account.getType();
         String commentUsername="";
       if(accType==1){
        Teacher teacher=   teacherService.findById(username);
        commentUsername=teacher.getTeaName();
       }
       else if(accType==2) {
           Student student=studentService.findById(username);
           commentUsername=student.getStuName();
       }
       comment.setCommentLogo(account.getAvatar());
       comment.setCommentName(commentUsername);
        comment.setCommentUser(account.getAccId());
      String commentTime=  DateTime.now().toString();
      comment.setCommentTime(commentTime);
        commentMapper.newComment(comment);


    }

    @Override
    public void reply(Comment comment) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        Account account= accountService.findByUsername(username);
        Integer accType=account.getType();
        String commentUsername="";
        if(accType==1){
            Teacher teacher=   teacherService.findById(username);
            commentUsername=teacher.getTeaName();
        }
        else if(accType==2) {
            Student student=studentService.findById(username);
            commentUsername=student.getStuName();
        }
        comment.setCommentName(commentUsername);
        comment.setCommentLogo(account.getAvatar());
        String commentTime=  DateTime.now().toString();
        comment.setCommentTime(commentTime);
        comment.setCommentUser(account.getAccId());
        commentMapper.reply(comment);
    }

    @Override
    public void delComment(Integer commentId) {
        commentMapper.delComment(commentId);
    }

    @Override
    public List<Comment> getSingle(Integer commentId) {
      return   commentMapper.getSingle(commentId);
    }

    @Override
    public List<Comment> getComments(Integer classId) {
       return   commentMapper.getComments(classId);

    }

    @Override
    public List<Comment> getSubComment(Integer commentId) {
         return commentMapper.getSubComment(commentId);
    }


}
