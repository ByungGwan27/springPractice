package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "empList";//파일이름. 확장자 제외
	}
	
	//단건조회 페이지
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		model.addAttribute("empinfo", empService.getEmpInfo(empVO));
		return "empinfo";
	}
	
	//등록 페이지
	@GetMapping("empInsert")
	public void empInsertForm(Model model) {//void형태면 경로를 통해 찾아감
		model.addAttribute("empVO", new EmpVO());//여기의 empVO, 등록 처리에 있는 empVO, empInsert에 있는 object의 empVO 3개의 명칭이 동일해야함
	}
	
	//등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO empVO) {
		empService.insertEmpInfo(empVO);
		return "redirect:empList";
	}
}
