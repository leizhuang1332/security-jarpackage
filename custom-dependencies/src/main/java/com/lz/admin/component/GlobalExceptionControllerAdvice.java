package com.lz.admin.component;

import com.alibaba.fastjson.JSON;
import com.lz.admin.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pzg
 * @date 2020/8/4
 * @description
 */
@Slf4j
@RestControllerAdvice(basePackages ="com.lz.admin.controller")
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public String handleVaildException(Exception e) {
        BindingResult bindingResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        } else if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        }
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) ->
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        String errors = JSON.toJSONString(errorMap);
        log.error("非法参数,信息:{}", errors);
        return Result.failure(400, errors);
    }
    @ExceptionHandler(value = {DuplicateKeyException.class})
    public String sqlException(Exception e) {
        log.error("数据重复:{}",e);
        return Result.failure(400, "您输入的信息已存在，请重新输入");
    }

}
