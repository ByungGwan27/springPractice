package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//전체조회 페이지
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", empService.getEmpList());
		return "emp/empList";//파일이름. 확장자 제외 그냥'/'입력시 리눅스로 옮기면 오류
	}
	
	//단건조회 페이지
	@GetMapping({"empInfo", "empInfo/{employeeId}"})//{}넣으면 배열로 여러개, 기본형식이 쿼리스트링, 두번쨰 방법이 pathvariable
	public String empInfo(EmpVO empVO, Model model, @PathVariable(required = false) int employeeId) {
		if(employeeId != 0) {
			empVO.setEmployeeId(employeeId);
		}
		//model.addAttribute("empinfo", empService.getEmpInfo(employeeId)); //이런 형식으로 바로 전달 가능
		model.addAttribute("empinfo", empService.getEmpInfo(empVO));
		return "emp/empInfo";
	}
	
	//등록 페이지
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {//void형태면 경로를 통해 찾아감
		model.addAttribute("empVO", new EmpVO());//여기의 empVO, 등록 처리에 있는 empVO, empInsert에 있는 object의 empVO 3개의 명칭이 동일해야함
		return "emp/empInsert";
	}
	
	//등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO empVO) {
		empService.insertEmpInfo(empVO);
		return "redirect:empList";
	}
	
	//07.10 수정 페이지
	@GetMapping("empUpdate")
	public String empUpdateForm(Model model, EmpVO vo) {
		model.addAttribute("empVO", empService.getEmpInfo(vo));
		return "emp/empUpdate";
	}
}
