package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	// java.util.Date를 사용하려면 setting이 필요함(mybatis-config.xml)
	@DateTimeFormat(pattern="yyyy-MM-dd")//input시 데이터 결정
	private Date regdate; // java에서 저 방식으로 'yyyy/mm/dd' 방식을 받음. input시 데이터 넘겨 주는 것은 'yyyy-mm-dd'
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedate;
	private String image; 
}
