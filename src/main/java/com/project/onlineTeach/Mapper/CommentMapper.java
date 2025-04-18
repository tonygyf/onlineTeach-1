package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.Controller.CommentController;
import com.project.onlineTeach.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment (commentUser,type,content,classId,commentName,commentLogo,commentTime) values (#{commentUser},0,#{content},#{classId},#{commentName},#{commentLogo},#{commentTime})")
    void newComment(Comment comment);
    @Insert("insert into comment(commentUser,type,replyToId,content,classId,commentName,commentLogo,commentTime) values (#{commentUser},1,#{replyToId},#{content},#{classId},#{commentName},#{commentLogo},#{commentTime})")
    void reply(Comment comment);
    @Delete("delete from comment where commentId=#{commentId} or replyToId=#{commentId}")
    void delComment(Integer commentId);
    @Select("select * from comment where commentId=#{commentId} or replyToId=#{commentId}")
    List<Comment> getSingle(Integer commentId);
    @Select("select * from comment where type=0 and classId=#{classId}")
    List<Comment> getComments(Integer classId);
    @Select("select * from comment where type=1 and replyToId=#{commentId}")
    List<Comment> getSubComment(Integer commentId);
}
