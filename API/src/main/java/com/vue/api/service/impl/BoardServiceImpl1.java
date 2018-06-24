package com.vue.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.api.mapper.BoardMapper1;
import com.vue.api.request.Req4020;
import com.vue.api.service.BoardService1;
import com.vue.api.vo.boardVo.BoardVo;
import com.vue.api.vo.boardVo.ReplyVo;

@Service
public class BoardServiceImpl1 implements BoardService1 {

	@Autowired
	private BoardMapper1 boardMapper;
	
	@Override
	public List<ReplyVo> findByreplyList(int boardNo) {
		return boardMapper.findByreplyList(boardNo);
	}

	@Override
	public int replyInsert(Req4020 req4020) {
		return boardMapper.replyInsert(req4020);
	}

	@Override
	public BoardVo boardDetail(int boardNo) {
		return boardMapper.boardDetail(boardNo);
	}

	
	
	
}
