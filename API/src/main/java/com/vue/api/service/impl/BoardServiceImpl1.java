package com.vue.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.api.mapper.BoardMapper1;
import com.vue.api.service.BoardService1;
import com.vue.api.vo.boardVo.ReplyVo;

@Service
public class BoardServiceImpl1 implements BoardService1 {

	@Autowired
	private BoardMapper1 boardMapper;
	
	@Override
	public List<ReplyVo> findByreplyList() {
		return boardMapper.findByreplyList();
	}

}
