package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	String employee_id;//마이바티스 셋팅 안할거라 '_'사용
	String first_name;
	String last_name;
}
