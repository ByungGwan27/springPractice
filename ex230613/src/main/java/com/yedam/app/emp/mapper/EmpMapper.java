package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// 전체조회
	public List<EmpVO> selectAllEmp();
	
	// 단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	//
	public int insertEmpInfo(EmpVO empVO);
}
