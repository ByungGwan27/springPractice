package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date hireDate;
	private String jobId;
	private int departmentId;
	private String profile;
	private MultipartFile uploadFile;
	
}
