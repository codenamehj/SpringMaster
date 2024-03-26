package com.dbal.app.book.mapper;

import java.util.List;

import com.dbal.app.book.model.BookVO;

public interface BookMapper {
	
	public int insertBook(BookVO bookVo);
	public int getBookNo();
	public List<BookVO> getBookList();
	public List<BookVO> getRentList();
}
