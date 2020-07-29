package com.lz.controller;

import com.lz.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    /**
     * 获取课程列表/课程收藏列表
     *
     * @return
     */
    @GetMapping("curriculum/list")
    public Object getCurriculumList() {

        return curriculumService.curriculumList();
    }
}
