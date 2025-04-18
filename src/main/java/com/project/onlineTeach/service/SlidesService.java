package com.project.onlineTeach.service;

import com.project.onlineTeach.entity.Slides;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface SlidesService {

    void addSlide(Slides slides);

    void delSlide(Integer slidesId);

    void updateSlide(Slides slides);

    Slides getSlide(Integer slidesId);

    List<Slides> getSlides(String courseId);
}
