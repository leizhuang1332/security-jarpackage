package com.lz.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 课程表
 */
@Data
public class Curriculum {
//    id	bigint
//    name	varchar
//    surface_img_url	varchar
//    path_img_url	varchar
//    control_scenario	varchar
//    control_flight	varchar
//    control_airport	varchar
//    runway	varchar
//    instruct_num	int
//    expect_duration	bigint
//    del	varchar

    /**
     * 主键
     */
    @JSONField(name = "curriculumId")
    private long id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程封面图片路径
     */
    private String surfaceImgUrl;
    /**
     * 训练路线图片路径
     */
    private String pathImgUrl;
    /**
     * 管制场景
     */
    private String controlScenario;
//    /**
//     * 航班编号
//     */
//    private String fnum;
//    /**
//     * 航司呼号
//     */
//    private String fcom;
    /**
     * 管制飞机
     */
    private String controlFlight;
    /**
     * 管制机场
     */
    private String controlAirport;
    /**
     * 相关跑道
     */
    private String runway;
    /**
     * 指令条数
     */
    private Integer instructNum;
    /**
     * 预计时长 单位(秒)
     */
    private long expectDuration;
    /**
     * 删除标识 1删除 0正常
     */
    private Integer del;

    /**
     * 机场英文名称
     */
    private String airport;

}
