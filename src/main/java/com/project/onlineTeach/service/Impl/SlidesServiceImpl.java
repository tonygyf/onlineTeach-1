package com.project.onlineTeach.service.Impl;

import com.project.onlineTeach.Mapper.SlidesMapper;
import com.project.onlineTeach.entity.Slides;
import com.project.onlineTeach.service.SlidesService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlidesServiceImpl implements SlidesService {
    @Autowired
    private SlidesMapper slidesMapper;

    @Override
    public void addSlide(Slides slides) {
        slidesMapper.addSlide(slides);
    }

    @Override
    public void delSlide(Integer slidesId) {
        slidesMapper.delSlide(slidesId);
    }

    @Override
    public void updateSlide(Slides slides) {
        slidesMapper.updateSlide(slides);
    }

    @Override
    public Slides getSlide(Integer slidesId) {
      return   slidesMapper.getSlide(slidesId);
     }

    @Override
    public List<Slides> getSlides(String courseId) {
        return slidesMapper.getSlides(courseId);

    }
}
