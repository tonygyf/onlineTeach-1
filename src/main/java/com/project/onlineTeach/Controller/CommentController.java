package com.project.onlineTeach.Controller;

import com.project.onlineTeach.entity.Comment;
import com.project.onlineTeach.entity.Result;
import com.project.onlineTeach.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/newComment")
    public Result newComment(@RequestBody Comment comment){
        /**
         * 新增评论
         */
        commentService.newComment(comment);
        return Result.success();
    }
    @PostMapping("/reply")
    public Result reply(@RequestBody Comment comment){
        /**
         * 回复评论
         */
        commentService.reply(comment);
        return Result.success();
    }
    @DeleteMapping("/del")
    public Result delComment(@RequestParam Integer commentId){
        commentService.delComment(commentId);
        return Result.success();
    }

    @GetMapping("/getSingle")
    public Result getSingle(Integer classId){
        /**
         *获取评论列表
         */
       List<Comment>topComments= commentService.getComments(classId);
       Integer size=topComments.size();
        List<responseComment> responseComments=new ArrayList<>(size);
        for(int i=0;i<topComments.size();i++){
            responseComment response=new responseComment();

            response.setComment(topComments.get(i));
            responseComments.add(response);

        }
       for(responseComment responseComment:responseComments){

           List<Comment>comments=commentService.getSubComment(responseComment.getComment().getCommentId());
           responseComment.setSubComment(comments);

       }
       return Result.success(responseComments);

    }
    static public class responseComment{
        private Comment comment;
        private List<Comment> subComment;

        @Override
        public String toString() {
            return "responseComment{" +
                    "comment=" + comment +
                    ", subComment=" + subComment +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            responseComment that = (responseComment) o;
            return Objects.equals(comment, that.comment) && Objects.equals(subComment, that.subComment);
        }

        @Override
        public int hashCode() {
            return Objects.hash(comment, subComment);
        }

        public Comment getComment() {
            return comment;
        }

        public void setComment(Comment comment) {
            this.comment = comment;
        }

        public List<Comment> getSubComment() {
            return subComment;
        }

        public void setSubComment(List<Comment> subComment) {
            this.subComment = subComment;
        }
    }
}
