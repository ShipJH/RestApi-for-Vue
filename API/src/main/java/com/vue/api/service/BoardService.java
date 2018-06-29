package com.vue.api.service;

import com.vue.api.request.Req4021;
import com.vue.api.response.Res4010;
import com.vue.api.response.Res4012;
import com.vue.api.response.Res4020;
import com.vue.api.response.Res4021;


public interface BoardService {

	/** 게시판 목록보기 (4010) */
	Res4010 findByBoardList();

	/** 게시글 상세보기 (4012) */
	Res4012 findByBoardDetail(int boardNo);

	/** 댓글 목록 (4020) */
	Res4020 findByReplyList(int boardNo);
	
	/** 댓글 작성 (4021) */
	Res4021 replyInsert(Req4021 req4020);
	

}
