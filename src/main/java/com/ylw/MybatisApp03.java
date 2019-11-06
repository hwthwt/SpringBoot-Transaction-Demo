package com.ylw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ylw.config.DBConfig1;
import com.ylw.config.DBConfig2;

// 开启读取配置文件
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
@SpringBootApplication
public class MybatisApp03 {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApp03.class, args);
	}

}
