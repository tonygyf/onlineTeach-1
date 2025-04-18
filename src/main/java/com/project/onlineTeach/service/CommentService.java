package com.project.onlineTeach.service;

import com.project.onlineTeach.Controller.CommentController;
import com.project.onlineTeach.entity.Comment;

import java.util.List;

public interface CommentService {
    void newComment(Comment comment);

    void reply(Comment comment);

    void delComment(Integer commentId);

    List<Comment> getSingle(Integer commentId);

    List<Comment> getComments(Integer classId);

    List<Comment> getSubComment(Integer commentId);
}
