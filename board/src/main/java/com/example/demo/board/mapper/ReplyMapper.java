package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.ReplyVO;

@Mapper
public interface ReplyMapper {
	// 댓글 등록
	int insertReply(ReplyVO vo);
	// 특정 게시판 댓글 리스트
	List<ReplyVO> getReply(Long bno);
	// 댓글 삭제
	int deleteReply(Long rno);
	// 댓글 수정
	int updateReply(ReplyVO vo);
}
