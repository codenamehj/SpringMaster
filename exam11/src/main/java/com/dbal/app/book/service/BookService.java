package com.dbal.app.book.service;

import java.util.List;

import com.dbal.app.book.model.BookVO;

public interface BookService {
	public int saveBook(BookVO bookVo);
	public int getBookNo();
	public List<BookVO> getBookList();
	public List<BookVO> getRentList();
}
