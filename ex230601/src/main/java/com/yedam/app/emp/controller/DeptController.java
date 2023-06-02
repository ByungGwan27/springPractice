package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.emp.mapper.DeptMapper;

@Controller
public class DeptController {
	@Autowired DeptMapper deptMapper;
	
	@RequestMapping("readDepartmentsAll")
	public String readDepartmentsAll(Model model) {
		model.addAttribute("dept", deptMapper.readDepartmentsAll());
		return "dept/deptList";
	}
	
}
