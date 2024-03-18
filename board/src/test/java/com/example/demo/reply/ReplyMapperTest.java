package com.example.demo.reply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;

@SpringBootTest
public class ReplyMapperTest {
	@Autowired
	ReplyMapper mapper;

	@Test
	public void 댓글등록() {
		ReplyVO vo = ReplyVO.builder().bno((long) 1).reply("몽룡도련님..").replyer("성춘향").build();
		int result = mapper.insertReply(vo);

		System.out.println("등록된 게시판 번호 : " + vo.getRno());
		System.out.println("등록된 게시글 수 : " + result);
	}
}
