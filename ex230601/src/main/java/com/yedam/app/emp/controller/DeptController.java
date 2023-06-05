//package com.yedam.app.emp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.yedam.app.emp.mapper.DeptMapper;
//import com.yedam.app.emp.service.DeptVO;
//
//@Controller
//public class DeptController {
//	@Autowired DeptMapper deptMapper;
//	
//	@RequestMapping("readDepartmentsAll")
//	public String readDepartmentsAll(Model model) {
//		model.addAttribute("dept", deptMapper.readDepartmentsAll());
//		return "dept/deptList";
//	}
//	
//	//부서 페이지 이동
//	@GetMapping("createDepartments")
//	public String createDepartmentsFrom(/*Model model*/) {
//		return "dept/deptInsert";
//	}
//	
//	@GetMapping("createDepartments")
//	public String createDepartments(DeptVO vo) {
//		deptMapper.createDepartments(vo);
//		return "redirect:deptList";
//	}
//	
//	@GetMapping("deleteDepartments")
//	public String deleteDepartments(@RequestParam int deptId) {
//		deptMapper.deleteDepartments(deptId);
//		return "redirect:deptList";
//	}
//	
//	@GetMapping("updateDepartments")
//	public String updateDepartmentsForm(Model model, int deptId) {
//		model.addAttribute("dept", deptMapper.readDepartmentsAll());
//		return "dept/deptUpdate";
//	}
//	
//	
//	
//}
