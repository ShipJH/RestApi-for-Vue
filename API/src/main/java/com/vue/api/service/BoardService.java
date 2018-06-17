package com.vue.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.api.mapper.BoardMapper;
import com.vue.api.service.impl.BoardServiceImpl;
import com.vue.api.vo.boardVo.BoardVo;

@Service
public class BoardService implements BoardServiceImpl{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVo> findByBoardList() {
		return boardMapper.findByBoardList();
	}
	
//	@Override
//	public TestVo getTest() {
//		 
//		return testMapper.getTestValue();
//	}

	
}
