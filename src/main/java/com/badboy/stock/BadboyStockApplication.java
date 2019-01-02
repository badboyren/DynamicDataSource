package com.badboy.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.badboy.stock.mapper")
@EnableScheduling
public class BadboyStockApplication {
	public static void main(String[] args) {
		SpringApplication.run(BadboyStockApplication.class, args);
	}
}
