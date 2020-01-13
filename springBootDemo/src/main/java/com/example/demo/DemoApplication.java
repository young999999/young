package com.example.demo;

import org.jasypt.digest.StandardByteDigester;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
	}



}
