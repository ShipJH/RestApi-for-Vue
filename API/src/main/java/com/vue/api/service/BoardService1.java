package com.vue.api.service;

import java.util.List;

import com.vue.api.request.Req4020;
import com.vue.api.vo.boardVo.BoardVo;
import com.vue.api.vo.boardVo.ReplyVo;

public interface BoardService1 {
	
	List<ReplyVo> findByreplyList();
	int replyInsert(Req4020 req4020);
	BoardVo boardDetail(int boardNo);

}
