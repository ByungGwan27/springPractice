package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
 * command
 * Pojo : 상속필요없음
 */
@Controller		//객체생성해서 컨테이너에 bean등록하고
//Spring 디스패처서블릿(dispath Servlet)에서 호출할 수 있도록 command type으로 만들어줌
//@Component 상속받음
public class EmpController {
	
	@Autowired EmpMapper empMapper;//mapper 호출
	
	//조회
	//@RequestMapping("empList")
	@GetMapping("empList")//get방식만 받을 수 있음
	public String empList(Model model, @ModelAttribute("emp") EmpVO vo) {
										//empList에서 EmpVO로 사용되던 것이 emp로 바뀜(as같음)
		System.out.println(vo);
		//model.addAttribute("emp", vo);
		model.addAttribute("empList", empMapper.selectList(vo));
		return "emp/empList";//주소호출
	}
	
	//사원등록 페이지로 이동
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("depts", empMapper.selectDepartments());
		return "emp/empInsert";
	}
	
	//사원등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		return "redirect:empList";// 뒤에 empList의 경우 mapping url을 적어줌
		//forward(아무것도 안 적으면) redirect.
	}
	
	//사원삭제 처리
	@GetMapping("empDelete")
	public String empDelete(@RequestParam int empId) {//RequestParam생략 가능
		System.out.println("찾아"+empId);
		//int empid = request/getParameter("empId")
		empMapper.deleteEmp(empId);
		return "redirect:empList";
	}
	
	//사원수정페이지로 이동
	@GetMapping("empUpdate")
	public String empUpdateForm(Model model, int empId) {
		model.addAttribute("emp", empMapper.selectOne(empId));
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("depts", empMapper.selectDepartments());
		return "emp/empUpdate";
	}
	
	//사원수정 처리
	@PostMapping("empUpdate")
	public String empUpdate(EmpVO vo) {
		empMapper.updateEmp(vo);
		return "redirect:empList";
	}
	
	
}