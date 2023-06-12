package com.yedam.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	//21 페이지
	
	@Value("${file.upload.path}")//'application.properties'(21페이지)의 내용을 가져오는 것. key값을 저장
	private String uploadPath;
	
//	@GetMapping("getUploadPath")
//	@ResponseBody
//	public String getUploadPath() {
//		return uploadPath;
//	}
	
	@GetMapping("upload")
	public void getUploadPath() {//void를 사용한 이유 : 경로랑 file이름이랑 같기 때문
	}
	
	//업로드 컨트롤 복붙
	@PostMapping("/uploadsAjax")
	@ResponseBody
	public void uploadFile(@RequestPart MultipartFile[] uploadFiles) {//배열 -> img파일을 하나만 받아오지 않기 때문
	    
	    for(MultipartFile uploadFile : uploadFiles){

	    	if(uploadFile.getContentType().startsWith("image") == false){//이미지, 영상, 음성중에서 이미지만 처리 하고싶을 때
	    		System.err.println("this file is not image type");
	    		return;
	        }
	  
	        String originalName = uploadFile.getOriginalFilename();
	        String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
	        
	        System.out.println("fileName : " + fileName);
	    
	        //날짜별 폴더 생성과 UUID로 서버 내에서 충돌 나지 않게 만들어줌
	        //날짜 폴더 생성
	        String folderPath = makeFolder();
	        //UUID(unique id)
	        String uuid = UUID.randomUUID().toString();
	        
	        String uploadFileName = folderPath + File.separator + uuid + "_" + fileName;
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분
	        String saveName = uploadPath + File.separator + folderPath +File.separator + uuid + "_" + fileName;
	        //separator는 java와 운영체제간 차이가 있음 java=\, window=/
	        //그래서 db에 바로 넣으면 안됨
	        
	        Path savePath = Paths.get(saveName);
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	uploadFile.transferTo(savePath);
	            //uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }

	        // DB에 해당 경로 저장
	        //1) 사용자가 업로드할 때 사용한 파일명
	        //2) 실제 서버에 업로드할 때 사용한 경로
	        
	        String imagePath = uploadFileName.replace(File.separator, "/");
	        System.out.println(uploadFileName);
	        System.out.println(imagePath);
	     }
	}

	private String makeFolder() {

		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator);

		File uploadPathFoler = new File(uploadPath, folderPath);
		// File newFile= new File(dir,"파일명");


		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}
	
//	private String setImagePath(String uploadFileName) {
//		return uploadFileName.replace(File.separatorChar, "/");
//	}
	
	
}