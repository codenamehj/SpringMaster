package com.example.demo.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {
	@Autowired
	BoardMapper mapper;

	@Test
	public void 게시판전체조회() {
		BoardVO vo = new BoardVO();
		vo.setEnd(50);
		List<BoardVO> list = mapper.getBoardList(vo);
		for (BoardVO boardVO : list) {
			System.out.println(boardVO.getBoardNo() + boardVO.getTitle() + boardVO.getWriter());;
		}
	}
}
