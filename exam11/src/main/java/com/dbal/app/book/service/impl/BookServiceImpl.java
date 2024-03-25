package com.dbal.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.book.mapper.BookMapper;
import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired BookMapper bookMapper;
	
	@Override
	public int saveBook(BookVO bookVo) {
		return bookMapper.insertBook(bookVo);
	}

	@Override
	public List<BookVO> getBookList() {
		return bookMapper.getBookList();
	}

	@Override
	public List<BookVO> getRentList() {
		return bookMapper.getRentList();
	}

}
