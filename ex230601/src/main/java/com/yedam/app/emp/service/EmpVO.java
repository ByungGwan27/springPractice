package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;//마이바티스 셋팅 안할거라 '_'사용
	String firstName;
	String lastName;
	String email;
	String hireDate;
	String jobId;
	String departmentId;
	String orderColumn;
	
	//체크박스 타입 값 넘겨주기
	String[] getDeptArr() {
		return departmentId.split(",");
	}
}
