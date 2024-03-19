package com.example.demo.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReplyRestController {
	@Autowired
	ReplyMapper mapper;

	@RequestMapping("/replyMng")
	public ModelAndView replyMng() { // @RestController 사용 시 ModelAndView로 페이지 이동.
		ModelAndView mv = new ModelAndView("/board/replyMng");
		return mv;
	}

	@GetMapping("/replyList/{bno}")
	public List<ReplyVO> replyList(@PathVariable Long bno) {
		return mapper.getReply(bno);
	}

	@PostMapping("/replies/insert")
	public ReplyVO save(ReplyVO vo) {
		mapper.insertReply(vo);
		return vo;
	}

	@GetMapping("/replies/{rno}")
	public ReplyVO info(@PathVariable Long rno) {
		return mapper.getReplyInfo(rno);
	}

	@RequestMapping("/replies/remove/{rno}")
	public int delete(@PathVariable Long rno) {
		return mapper.deleteReply(rno);
	}

	@PostMapping("/replies/update")
	public ReplyVO update(ReplyVO vo) {
		mapper.updateReply(vo);
		return vo;
	}
}
