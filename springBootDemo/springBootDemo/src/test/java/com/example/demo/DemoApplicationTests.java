package com.example.demo;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.exceptions.JedisMovedDataException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//@SpringBootTest
class DemoApplicationTests {
    @Test
    public void test() {

//        JedisPoolConfig config = new JedisPoolConfig();
//        // 最大连接数
//        config.setMaxTotal(30);
//        // 最大连接空闲数
//        config.setMaxIdle(2);
//
//        config.setMaxWaitMillis(2000);

        Set<HostAndPort> set = new HashSet<HostAndPort>();
//        set.add(new HostAndPort("47.98.53.232", 9001));
//        set.add(new HostAndPort("47.98.53.232", 9002));
//        set.add(new HostAndPort("47.98.53.232", 9003));
//        set.add(new HostAndPort("47.98.53.232", 9004));
//        set.add(new HostAndPort("47.98.53.232", 9005));
//        set.add(new HostAndPort("47.98.53.232", 9006));
        set.add(new HostAndPort("47.98.53.232", 7001));
        set.add(new HostAndPort("47.98.53.232", 7002));
        set.add(new HostAndPort("47.98.53.232", 7003));
        set.add(new HostAndPort("47.98.53.232", 7004));
        set.add(new HostAndPort("47.98.53.232", 7005));
        set.add(new HostAndPort("47.98.53.232", 7006));
//        set.add(new HostAndPort("192.168.1.128", 9001));
//        set.add(new HostAndPort("192.168.1.128", 9002));
//        set.add(new HostAndPort("192.168.1.128", 9003));
//        set.add(new HostAndPort("192.168.1.128", 9004));
//        set.add(new HostAndPort("192.168.1.128", 9005));
//        set.add(new HostAndPort("192.168.1.128", 9006));
        JedisCluster jedisCluster = new JedisCluster(set);
        jedisCluster.set("b", "base");
        System.out.println(jedisCluster.get("a"));
        jedisCluster.close();

    }



    String ip="47.98.53.232";
//    String ip="192.168.1.128";
    int port=7001;
    Jedis jedis = new Jedis(ip, port);
    String s="a";
    @Test
    public void testGet() {
        try {

            System.out.println(jedis.get(s));
        } catch (JedisMovedDataException e) {
            System.out.println(e.getMessage());
            String mes = e.getMessage();
            String[] mess = mes.split(":");
            //System.out.println(mess[1]);
            int i = Integer.parseInt(mess[1]);
            jedis = new Jedis(ip, i);
//            System.out.println("清除redis集群"+jedis.flushDB());
            System.out.println(jedis.get(s));
        }finally {
            jedis.close();
        }
    }


    @Test
    public void testSet() {
//        for (int i = 9001; i < 9007; i++) {
//            Jedis jedis = new Jedis("47.98.53.232", i);
//            //jedis.set("a","a");
//            //查看服务是否运行，打出 pong 表示 OK
//            System.out.println(i + " connection is OK=======>:" + jedis.ping());
//        }

//        Jedis jedis = new Jedis("47.98.53.232", 9001);

        try {

            System.out.println(jedis.set(s,s));
        } catch (JedisMovedDataException e) {
            System.out.println(e.getMessage());
            String mes = e.getMessage();
            String[] mess = mes.split(":");
            //System.out.println(mess[1]);
            int i = Integer.parseInt(mess[1]);
            jedis = new Jedis(ip, i);
            System.out.println(jedis.set(s,s));
        }finally {
            jedis.close();
        }
    }


    @Test
    public void test1(){
        System.out.println(System.currentTimeMillis());
    }
}
