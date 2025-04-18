package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.AnsRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AnswerMapper {
    @Insert({
            "<script>",
            "insert into ansrecord (stuId, paperExeId, stuAns, stuScore) values ",
            "<foreach collection='answers' item='answer' separator=','>",
            "(#{answer.stuId}, #{answer.paperExeId}, #{answer.stuAns}, 0)",
            "</foreach>",
            "</script>"
    })
    void newAns(List<AnsRecord> answers);
    @Update("update ansrecord set stuScore=#{score} where paperExeId=#{paperExeId} and stuId=#{stuId}")
    void updateScore(Integer score, Integer paperExeId, String stuId);
    @Delete("delete from ansrecord where paperExeId in(select paperExeId from paperexe where exeId=#{exeId})")
    void delRecord(Integer exeId);
}
