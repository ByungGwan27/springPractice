package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	//전체조회
	public List<BookVO> getBookAllList();
	
	//단건조회 - 도서번호 예측
	public int getBookNo();
	
	//등록
	public int insertBookInfo(BookVO bookVO);
	
	public List<RentVO> getBookRentList();
}
