package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public List<DeptVO> readDepartmentsAll();
	public int createDepartments(DeptVO vo);
	public int updateDepartments(DeptVO vo);
	public int deleteDepartments(int deptId);
}
