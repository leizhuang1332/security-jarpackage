package com.lz.service;

import com.lz.bean.Curriculum;
import com.lz.mapper.CurriculumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumMapper curriculumMapper;

    /**
     * 首页的课程列表
     * 依赖redis key:"trainingRecord" 数据，首页查询训练记录汇总时缓存
     *
     * @return 课程列表
     */
    public List<Curriculum> curriculumList() {
        List<Curriculum> curriculumList;

        curriculumList = Optional.ofNullable(curriculumMapper.selectList()).orElse(new ArrayList<>());

        return curriculumList;
    }

}
