package com.py.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.py.springcloud"})
//@ComponentScan("com.py.springcloud")
public class DeptConsumer_Feign_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer_Feign_App.class, args);
	}
}
