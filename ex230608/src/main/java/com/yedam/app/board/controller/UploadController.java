package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {
	//21 페이지
	
	@Value("${file.upload.path}")//'application.properties'(21페이지)의 내용을 가져오는 것. key값을 저장
	private String uploadPath;
	
	@GetMapping("getUploadPath")
	@ResponseBody
	public String getUploadPath() {
		return uploadPath;
	}
}
