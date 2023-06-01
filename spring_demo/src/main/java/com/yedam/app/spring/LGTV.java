package com.yedam.app.spring;

import org.springframework.stereotype.Component;

//뒤에는 이름 지칭. 인터페이스에는 사용 불가
@Component("tv")
public class LGTV implements TV {

	@Override
	public void on() {
		System.out.println("스프링으로 LG TV 켬");
	}

}
