package com.yedam.java.book.service;

import lombok.Data;

@Data
public class RentVO {
	private int bookNo;
	private String bookName;
	private int rentTotalPrice;//컬럼 명 참고(as적용)
	private int rentCount;
}
