package com.example.demo;

/**
 * @author young
 * @create 2020-01-16 21:39
 */
public class Jvm {
    public static void main(String[] args) {
        System.out.println("Xmx"+Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println("Xms"+Runtime.getRuntime().totalMemory()/1024/1024);
    }
}
