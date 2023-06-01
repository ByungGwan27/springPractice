package com.yedam.myapp;

import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;

//bean을 가져오려면 아래 두 어노테이션 들고옴
@RunWith(SpringJUnit4ClassRunner.class)//클래스 전체를 가져오려면 .class를 사용
@ContextConfiguration("classpath:applicationContext.xml")
public class TestClass {
	
	// 오토라이드로 불러옴
	@Autowired
	Restaurant res;
	
	@Test
	public void creatBeanTest() {
		res.open();
	}
	
	//아래 어노테이션을 붙이면 테스트 가능
	@Ignore//@Test
	public void test() {
		System.out.println("간단한 테스트");
		assertNull(null);
	}
}
