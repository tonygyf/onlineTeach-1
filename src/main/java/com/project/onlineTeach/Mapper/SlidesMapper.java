package com.project.onlineTeach.Mapper;

import com.project.onlineTeach.entity.Slides;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SlidesMapper {
@Insert("insert into slides (courseId,title,url,sectionId) values (#{courseId},#{title},#{url},#{sectionId})")
    void addSlide(Slides slides);
@Delete("delete  from slides where slidesId=#{slidesId}")
    void delSlide(Integer slidesId);
@Update("update  slides set title=#{title}, url=#{url},sectionId=#{sectionId} where slidesId=#{slidesId}")
    void updateSlide(Slides slides);
@Select("select  * from slides where slidesId=#{slidesId}")
    Slides getSlide(Integer slidesId);
@Select("select * from slides where courseId=#{courseId} ORDER BY sectionId")
    List<Slides> getSlides(String courseId);
}
