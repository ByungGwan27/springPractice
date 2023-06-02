package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	
	@Autowired
	EmpMapper empMapper; //Autowired는 인터페이스를 상속받은 구현클래스 주입받음
	
	//@Test
	public void getEmpInfo() {
		EmpVO findEmp = empMapper.selectOne(100);
		System.out.println(findEmp);
		assertEquals(findEmp.getFirstName(), "Steven");//2개를 비교, t or f
	}
	
	//@Test
	public void 전체조회() {
		EmpVO vo = new EmpVO();
		vo.setDepartmentId("50,40");
		//vo.setFirstName("e");
		vo.setOrderColumn("department_id, first_name");
		List<EmpVO> list = empMapper.selectList(vo);
		int cnt = empMapper.selectCount(vo);
		
		//필터했기 떄문에 아래는 딱히 필요 없음
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
		//System.out.println(list.get(0));
		//assertEquals(list.get(0).getEmployeeId(), "100");
	}
	//@Test
	public void 등록() {
		EmpVO vo = new EmpVO();
		vo.setLastName("naru3");
		vo.setEmail("naru3@email.com");
		vo.setHireDate("2023-05-04");
		vo.setJobId("IT_PROG");
		
		empMapper.insertEmp(vo);
		//int result = empMapper.insertmember(vo);
		//등록 후에 id를 사용하고자 할 경우 selectkey 이용
		System.out.println(vo.getEmployeeId());
		
		//assertEquals(result, 1);//Test자동화 할때는 assertEquals를 사용해야함 안쓰면 테스트에 초록색창이 안뜸
		
//		//void로 할 시
//		EmpVO findEmp = empMapper.selectOne(Integer.parseInt(vo.getEmployee_id()));
//		assertEquals(findEmp.getFirst_name(), result);
		
	}
	
	@Test
	public void selectJobs() {
		List<Map<String, Object>> list =
				empMapper.selectJobs();
		assertNotNull(list);
	}
	
	
	
}
