package com.ram.jobjot.jobjot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class JobjotApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JobjotApplication.class, args);


		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
