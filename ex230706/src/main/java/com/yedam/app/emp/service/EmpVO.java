package com.yedam.app.emp.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder//builder가 들어가면 noargs, allargs적어줘야함
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	@JsonIgnore
	private String email;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	//@JsonProperty("sal")//jacksonTest용
	private BigDecimal salary;
	private int departmentId;
	private String profile;
	private MultipartFile uploadFile;
	
}
