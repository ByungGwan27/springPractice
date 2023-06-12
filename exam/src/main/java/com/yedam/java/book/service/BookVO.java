package com.yedam.java.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	private int bookNo;
	private String bookName;
	private String bookCoverimg;
	// java 날짜 디폴트 : yyyy/MM/dd
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bookDate;
	//private int bookPrice;
	//null값을 처리하기 위해
	private Integer bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	public void setBookPrice(Integer bookPrice) {//set 을 추가로 만들어 주기 위해서는 변수 안의 타입을 맞춰줘야함
		if(bookPrice == null) {
			this.bookPrice = 0;
		} else {
			this.bookPrice = bookPrice;
		}
	}
}
