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
		vo.setWriter("홍");
//		vo.setTitle("안녕");
		List<BoardVO> list = mapper.getBoardList(vo);
		for (BoardVO boardVO : list) {
			System.out.println(boardVO.getBoardNo() + " " + boardVO.getTitle() + " " + boardVO.getWriter());
			;
		}
	}

	@Test
	public void 게시판단건조회() {
		int boardNo = 41;
		BoardVO vo = mapper.getBoardInfo(boardNo);
		System.out.println(vo);
	}

	@Test
	public void 게시글등록() {
		BoardVO vo = BoardVO.builder().title("집에 갈래").content("가즈아~~").writer("홍길동").build();
		int result = mapper.insertBoard(vo);

		System.out.println("등록된 게시판 번호 : " + vo.getBoardNo());
		System.out.println("등록된 게시글 수 : " + result);
	}

	@Test
	public void 게시글삭제() {
		int result = mapper.deleteBoard(43);
		System.out.println("삭제건수 = " + result);
	}
	
	@Test
	public void 게시글수정() {
		BoardVO vo = BoardVO.builder().boardNo(62).title("예담학원").content("가즈아~~!!").build();
		int result = mapper.updateBoard(vo);
		
		System.out.println("수정된 게시글 수 : " + result);
	}
}
