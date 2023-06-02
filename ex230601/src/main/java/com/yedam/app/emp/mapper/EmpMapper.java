package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectOne(int empNo);
	public int selectCount(EmpVO vo);
	public List<EmpVO> selectList(EmpVO vo);
	public int insertEmp(EmpVO vo); //등록
	public int updateEmp(EmpVO vo); //수정
	public int deleteEmp(int empNo); //삭제
	public List<Map<String, Object>> selectJobs();//타입따라 받고싶으면 Object. vo대신 list map을 사용
	//public Map<String, String> selectJobs();
	public List<Map<String, Object>> selectDepartments();//타입따라 받고싶으면 Object. vo대신 list map을 사용
}
