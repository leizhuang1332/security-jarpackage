package com.lz.admin.controller.base;

import com.lz.admin.dto.Result;
import org.springframework.http.HttpStatus;

public class BaseController {

    /**
     * 成功
     *
     * @return
     */
    protected String success() {
        return Result.success();
    }

    /**
     * 成功
     *
     * @param data 数据
     * @return
     */
    protected String success(Object data) {
        if (data == null)
            return new Result(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name()).converter();
        return Result.success(data);
    }

    /**
     * 失败
     *
     * @param msg 错误信息
     * @return
     */
    protected String failure(String msg) {
        return Result.failure(msg);
    }

    /**
     * 失败
     *
     * @param code 状态码
     * @param msg  错误信息
     * @return
     */
    protected String failure(Integer code, String msg) {
        return Result.failure(code, msg);
    }
}
