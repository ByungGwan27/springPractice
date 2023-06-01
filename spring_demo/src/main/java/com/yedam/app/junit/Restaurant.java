package com.yedam.app.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	// 필요한 클래스 선언 후 아래 어노테이션 선언
	@Autowired
	Chef chef;
	
	public void open() {
		chef.cooking();//클래스 내에 new 연산자 사용x
	}
	
}
