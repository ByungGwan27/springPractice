package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");//공백x 이름 정확해야함
		
		TV tv = (TV)ctx.getBean("tv");
		tv.on();
	}
	
}
