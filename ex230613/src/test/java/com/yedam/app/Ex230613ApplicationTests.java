package com.yedam.app;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex230613ApplicationTests {
	
	@Autowired
	StringEncryptor jasyptStringEncryptor;
	
	@Test
	void propertiesEncrypt() {
		//암호화 하고자 하는 대상 들고오기
		//배열을 쓴 이유 : 편해서
		String[] strArray = {"oracle.jdbc.driver.OracleDriver",
							 "jdbc:oracle:thin:@127.0.0.1:1521/xe",
							 "hr",
							 "hr"};
		
		for(String str : strArray) {
			String enyStr = jasyptStringEncryptor.encrypt(str);
			System.out.println(enyStr);//print쓰지 말것
		}
	}

}
