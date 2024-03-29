package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BoardVO;
import com.example.demo.board.ReplyVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoardInfo(int boardNo);
	int insertBoard(BoardVO vo);
	int deleteBoard(int boardNo);
	int updateBoard(BoardVO vo);
}
