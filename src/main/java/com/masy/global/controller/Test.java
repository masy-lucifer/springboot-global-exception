package com.masy.global.controller;

import com.alibaba.fastjson.JSON;
import com.masy.global.exception.BusinessException;
import com.masy.global.exception.ErrorCode;
import com.masy.global.exception.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author masy
 * @Date 2023/4/322:54
 **/
@RestController
@RequestMapping("test")
public class Test {

    @GetMapping()
    public Map<String,String> test() {
        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        return map;
    }

    @GetMapping("success")
    public Result<Map<String,String>> test1() {
        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        return Result.success(map);
    }


    @GetMapping("fail")
    public Result<String> fail(){
        throw new BusinessException(ErrorCode.PARAM_ERROR);
    }
}
