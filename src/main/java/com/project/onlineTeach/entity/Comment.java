package com.project.onlineTeach.entity;

import java.util.List;
import java.util.Objects;

public class Comment {
    private Integer commentId;
    private Integer commentUser;
    private Integer type;
    private Integer replyToId;
    private String content;
    private Integer classId;
    private String commentLogo;
    private String commentTime;
private String commentName;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentUser=" + commentUser +
                ", type=" + type +
                ", replyToId=" + replyToId +
                ", content='" + content + '\'' +
                ", classId=" + classId +
                ", commentLogo='" + commentLogo + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", commentName='" + commentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) && Objects.equals(commentUser, comment.commentUser) && Objects.equals(type, comment.type) && Objects.equals(replyToId, comment.replyToId) && Objects.equals(content, comment.content) && Objects.equals(classId, comment.classId) && Objects.equals(commentLogo, comment.commentLogo) && Objects.equals(commentTime, comment.commentTime) && Objects.equals(commentName, comment.commentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, commentUser, type, replyToId, content, classId, commentLogo, commentTime, commentName);
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(Integer commentUser) {
        this.commentUser = commentUser;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(Integer replyToId) {
        this.replyToId = replyToId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getCommentLogo() {
        return commentLogo;
    }

    public void setCommentLogo(String commentLogo) {
        this.commentLogo = commentLogo;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }
}
