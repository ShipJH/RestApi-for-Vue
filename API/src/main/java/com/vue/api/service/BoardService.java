package com.vue.api.service;

import java.util.List;

import com.vue.api.vo.boardVo.BoardVo;

//import com.vue.api.vo.TestVo;

public interface BoardService {

	List<BoardVo> findByBoardList();
//	TestVo getTest(); 
}
