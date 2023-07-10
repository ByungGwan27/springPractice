package com.yedam.app.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	//@GetMapping("/ajax/empList")
	@GetMapping("employees")
	public List<EmpVO> empList() {
		return empService.getEmpList();
	}
	
	@GetMapping("employees/{employeeId}")
	public List<EmpVO> empList(@PathVariable int employeeId, EmpVO vo) {
		vo.setEmployeeId(employeeId);
		return empService.getEmpList();
	}
	
	//등록
	@PostMapping("employees")
	public EmpVO empInsert(EmpVO vo) {
		empService.insertEmpInfo(vo);
		return vo;
	}
	
	//수정
	@PutMapping("employees")
	public EmpVO empUpdate(@RequestBody EmpVO vo) {//07.10 리퀘스트 바디가 없으면 jsonString, 있으면 쿼리스트링
		System.out.println(vo);
		//empService.updateEmpInfo(vo);
		return vo;
	}
	
	@DeleteMapping("employees/{id}")
	public int empDelete(@PathVariable(name = "id") int empid) {//pathvariable과 받을 변수가 같으면 뒤에 name부분 생략 가능
		System.out.println(empid);
		//empService.deleteEmpInfo(id);
		return empid;
	}
//	@DeleteMapping("employees/{id}")
//	public EmpVO empDelete(@PathVariable(name = "id") String empid) {//pathvariable과 받을 변수가 같으면 뒤에 name부분 생략 가능
//		System.out.println(empid);
//		//empService.deleteEmpInfo(id);
//		return empid;
//	}
}
