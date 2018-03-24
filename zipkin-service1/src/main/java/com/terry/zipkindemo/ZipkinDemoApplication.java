package com.terry.zipkindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@ComponentScan()
public class ZipkinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDemoApplication.class, args);
	}
}
