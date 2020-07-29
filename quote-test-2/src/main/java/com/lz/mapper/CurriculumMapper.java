package com.lz.mapper;

import com.lz.bean.Curriculum;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumMapper {

    List<Curriculum> selectList();
}
