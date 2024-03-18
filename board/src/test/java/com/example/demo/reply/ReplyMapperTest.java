package com.example.demo.reply;

import java.util.List;

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
		ReplyVO vo = ReplyVO.builder().bno((long) 1).reply("나의 죽음을 적에게 알리지 마라...").replyer("이순신").build();
		int result = mapper.insertReply(vo);

		System.out.println("등록된 게시판 번호 : " + vo.getRno());
		System.out.println("등록된 게시글 수 : " + result);
	}
	
	@Test
	public void 댓글조회() {
		Long bno = (long) 1;
		List<ReplyVO> list = mapper.getReply(bno);
		for(ReplyVO reply : list) {
			System.out.println(reply);
		}
	}
	
	@Test
	public void 댓글삭제() {
		Long rno = (long) 2;
		int result = mapper.deleteReply(rno);
		
		System.out.println("삭제된 게시글 수 : " + result);
	}
}
