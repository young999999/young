package com.example.demo.controller;

import com.example.demo.javabean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisMovedDataException;

import java.util.concurrent.TimeUnit;

/**
 * @author young
 * @create 2019-12-22 11:08
 */


@RestController
@Api(tags = {"WORD",})

public class Word {

    @Autowired

    RedisTemplate redisTemplate;


    @PostMapping("/word")
//    @ResponseStatus(value= HttpStatus.OK,reason="yes")
    @ApiOperation(value = "这是测试word的方法", notes = "有关word的说明"/*, consumes = "application/json"*/)
    @ResponseBody

    public String hello(@RequestBody User user) {

//        System.err.println(user);
redisTemplate.setStringSerializer(RedisSerializer.string());
        redisTemplate.opsForValue().set(user.getName(), user.getSex());//向redis里存入数据和设置缓存时间
        System.err.println(redisTemplate.opsForValue().get(user.getName()));
        System.err.println(redisTemplate.opsForValue().get(user.getAge()));
//        testSet(user.getName());
//        testGet(user.getName());
        return "word";
    }


    String ip = "47.98.53.232";
    int port = 9001;
    Jedis jedis = new Jedis(ip, port);


    public void testGet(String arg) {
        try {

            System.err.println(jedis.get(arg));
        } catch (JedisMovedDataException e) {
            System.out.println(e.getMessage());
            String mes = e.getMessage();
            String[] mess = mes.split(":");
            //System.out.println(mess[1]);
            int i = Integer.parseInt(mess[1]);
            jedis = new Jedis(ip, i);
//            System.err.println("清除redis集群"+jedis.flushDB());
            System.err.println(jedis.get(arg));
        } finally {
            jedis.close();
        }
    }

    public void testSet(String arg ) {
//        for (int i = 9001; i < 9007; i++) {
//            Jedis jedis = new Jedis("47.98.53.232", i);
//            //jedis.set("a","a");
//            //查看服务是否运行，打出 pong 表示 OK
//            System.out.println(i + " connection is OK=======>:" + jedis.ping());
//        }

//        Jedis jedis = new Jedis("47.98.53.232", 9001);

        try {

            System.err.println(jedis.set(arg,arg));
        } catch (JedisMovedDataException e) {
            System.err.println(e.getMessage());
            String mes = e.getMessage();
            String[] mess = mes.split(":");
            //System.out.println(mess[1]);
            int i = Integer.parseInt(mess[1]);
            jedis = new Jedis("192.168.1.128", i);
            System.err.println(jedis.set(arg,arg));
        }finally {
            jedis.close();
        }
    }
}
