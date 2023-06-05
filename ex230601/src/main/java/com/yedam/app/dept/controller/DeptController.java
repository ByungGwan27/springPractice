package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.dept.service.DeptService;

@Controller("deptInfo")
public class DeptController {
	@Autowired
	DeptService deptService;
	
	// 경로를 등록하고, 경로와 기능 (view(페이지)와 연결)
	// 경로 <-> 기능 ( View )
	// 경로 + Method -> Unique, 경로 뿐만 아니라 경로+Method 한 것이 유니크한 값이어야 함
	
	// 기본 골격은 String
	//@RequestMapping("/deptList")//RequestMapping로 주소를 등록하면 메소드 상관없이 대응하겠다
	//@RequestMapping(value = "deptList", method = HttpMethod.POST )//RequestMapping을 특정한 메소드에 대응 시키려면
	
	// 조회 ( 데이터, 페이지 ) -> GET
	// 등록, 수정, 삭제 -> POST
	
	//전체조회 - 페이지
	@GetMapping("deptList")
	public String getDeptAllList(@RequestParam(required = false) String msg, Model model, HttpServletRequest request) {//model이 리퀘스트나 리스폰스를 관리하게 편하게 하기위해서 spring에서 사용
		model.addAttribute("deptList", deptService.getAllDept());
		
		System.out.println("redirect : " + msg);
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			System.out.println("department_id : " + flashMap.get("departmentId"));
		}
		
		return "dept/list";
	}
	
	//단건조회 - 페이지
	@GetMapping("deptInfo")
	public String getDeptInfo(DeptInfoVO deptVO, Model model) {
		DeptInfoVO findDept = deptService.getDeptInfo(deptVO);
		model.addAttribute("deptInfo", findDept);
		return "dept/info";
	}
	
	//등록 - 페이지 : GET
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";//순수하게 해당 페이지만 들어갈 때는 return값만 있으면 된다
	}
	
	//등록 - 기능 : POST
	@PostMapping("deptInsert")
	public String deptInsert(DeptInfoVO deptVO, RedirectAttributes rtt) {//RedirectAttributes spring 방식
		deptService.insertDeptInfo(deptVO);
		rtt.addFlashAttribute("departmentId", deptVO.getDepartmentId());//2. 주소를 다른데 담아서 보내기. 경로에 값이 붙지 않음, session에 값을 저장했다가 사용하면 값을 옮김
		rtt.addAttribute("msg", "test"); // ?msg=test
		//return "redirect:deptList?departmentId="+deptVO.getDepartmentId();//1. 주소에 정보를 붙여서 보내는 방식, redirect는 post방식을 사용 못함
		return "redirect:deptList";//2-2.
	}
	
	//수정 - 기능 : POST
	//@RequestBody : JSON 포맷을 사용하는 경우
	//				 -> content-type : 'application/json'
	@PostMapping("deptUpdate")
	@ResponseBody//ResponseBody를 받으면 String을 받을 필요 x -> 받겠다면 Map을 이용/ view(조회)가 필요 없다고 하는 어노테이션 -> 값만 받겠다. json뿐만 아니라 text도 받을 수 있음
	public Map<String, Object> deptUpdate(@RequestBody List<DeptInfoVO> deptVO, RedirectAttributes rtt) {
	//public Map<String, Object> deptUpdate(List<DeptInfoVO> deptVO, RedirectAttributes rtt) { //경우에 따라선 @RequestBody필요 없을 수 있음
		Map<String, Object> map = deptService.updateDeptList(deptVO);
		rtt.addFlashAttribute("updateRes", map);
		//return "redirect:deptInfo?departmentId="+deptVO.get(0).getDepartmentId();//fetch를 사용 할 땐 해당 return문을 쓰면 안됨
		return deptService.updateDeptList(deptVO);
	}
	
//	//text로 받는 경우
//	@PostMapping("deptUpdate")
//	@ResponseBody
//	public String deptUpdateText(@RequestBody List<DeptInfoVO> deptVO) {
//		Map<String, Object> map = deptService.updateDeptList(deptVO);
//		return "success";
//	}
	
	//삭제 - 기능 : POST
	@PostMapping("deptDelete")
	public String deptDelete(DeptListVO list) {
		int result = deptService.deleteDeptList(list.getDeptList());
		return "redirect:deptList?msg=" + result;
	}
}
