package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController {
	@Autowired
	EmpMapper empMapper;
	
	//전체조회
	@GetMapping("emps")//restController는 조회하는 자원이 뭔지 명시해주면 됨
	public List<EmpVO> getEmpList() {
		EmpVO vo = new EmpVO();
		return empMapper.selectList(vo);
	}
	
	//단건조회
	@GetMapping("emps/{employeeId}")
	public EmpVO getEmpInfo(@PathVariable int employeeId) {
	//public EmpVO getEmpInfo(@PathVariable(name="employeeId") int empId) {
		return empMapper.selectOne(employeeId);
	}
	
	//등록
	@PostMapping("emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) {
		empMapper.insertEmp(empVO);
		return empVO;
	}
	
	//수정
	@PutMapping("emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable String employeeId,
								@RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		empMapper.updateEmp(empVO);
		return empVO;
	}
	
	//삭제
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> deleteEmpInfo(@PathVariable int employeeId) {
		boolean success = false;
		int result = empMapper.deleteEmp(employeeId);
		if(result > 0) {
			success = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", success);
		map.put("employeeId", employeeId);
		return map;
	}
}
