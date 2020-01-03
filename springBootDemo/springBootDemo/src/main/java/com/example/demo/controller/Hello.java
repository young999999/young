package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author young
 * @create 2019-12-22 11:08
 */
@RestController

@Api(tags = "HELLO")
@ControllerAdvice
public class Hello {
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/hello")
//    @ResponseStatus(value= HttpStatus.OK,reason="yes")
    @ResponseBody
    public String hello() {

        System.err.println(redisTemplate.opsForValue().get("b"));
        return "hello";
    }


    //需要在类上添加@ControllerAdvice注解
    //@ExceptionHandler(Exception.class)
    //@ResponseBody
    public /*ResponseEntity<String>*/String handleIOException(Exception ex) {
        // prepare responseEntity
        System.err.println(ex.getMessage());

        return "出现异常啦";
    }
}
