package com.vue.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vue.api.mapper.BoardMapper;
import com.vue.api.request.Req4020;
import com.vue.api.request.Req4021;
import com.vue.api.response.Res4010;
import com.vue.api.response.Res4010List;
import com.vue.api.response.Res4012;
import com.vue.api.response.Res4020;
import com.vue.api.response.Res4020List;
import com.vue.api.response.Res4021;
import com.vue.api.service.BoardService;
import com.vue.api.util.DateUtil;
import com.vue.api.util.PageUtil;
import com.vue.api.util.commonCode.MsgEnum;
import com.vue.api.vo.boardVo.BoardVo;
import com.vue.api.vo.boardVo.ReplyVo;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	/** 게시판 목록보기 (4010) 
	 * @param pageInfo 
	 * @param request */
	@Override
	public Res4010 findByBoardList(Req4020 request, PageUtil pageSetting) {
		
		Res4010 response = new Res4010();
		List<BoardVo> boardVo = boardMapper.findByBoardList(request,pageSetting);
		for(BoardVo list : boardVo) {
			Res4010List res4010List = new Res4010List(); 
			res4010List.setBoardNo(list.getBoardNo());
			res4010List.setTitle(list.getTitle());
			//TODO: UseYn 까지 갖고올 수 있도록 쿼리 변경요망
			res4010List.setUseYn(list.getUseYn());
			res4010List.setRegUser(list.getRegUser());
			res4010List.setRegDate(DateUtil.localDateTimeToStrDetail(list.getRegDate()));
			res4010List.setReplyCnt(list.getReplyCnt());
			response.addList(res4010List);
		}
		
		response.setListCnt(boardMapper.findByBoardListCnt(request));
		response.setPageNo(request.getPageNo());
		
		response.setResResult(MsgEnum.SUCCESS.getCode());
		response.setResMsg(MsgEnum.SUCCESS.getMsg());
		response.setResDate(DateUtil.toCurrentDefaultDateString());
		
		return response;
	}
	
	
	/** 게시글 상세보기 (4012) */
	@Override
	public Res4012 findByBoardDetail(int boardNo) {
		
		Res4012 response = new Res4012();
		BoardVo boardVo = boardMapper.findByBoardDetail(boardNo);
		
		response.setBoardNo(boardVo.getBoardNo());
		response.setTitle(boardVo.getTitle());
		response.setUseYn(boardVo.getUseYn());
		response.setRegUser(boardVo.getRegUser());
		response.setRegDate(DateUtil.localDateTimeToStrDetail(boardVo.getRegDate()));
		response.setReplyCnt(boardVo.getReplyCnt());
		
		response.setResResult(MsgEnum.SUCCESS.getCode());
		response.setResMsg(MsgEnum.SUCCESS.getMsg());
		response.setResDate(DateUtil.toCurrentDefaultDateString());
		
		return response;
	}
	
	
	/** 댓글 목록 (4020) */
	@Override
	public Res4020 findByReplyList(int boardNo) {
		
		Res4020 response = new Res4020();
		List<ReplyVo> relpyVo = boardMapper.findByreplyList(boardNo);
		
		for(ReplyVo list : relpyVo) {
			Res4020List res4020List = new Res4020List();
			res4020List.setReplyNo(list.getReplyNo());
			res4020List.setBoardNo(list.getBoardNo());
			res4020List.setReplyGroup(list.getReplyGroup());
			res4020List.setContent(list.getContent());
			res4020List.setUseYn(list.getUseYn());
			response.addList(res4020List);
		}
		
		response.setResResult(MsgEnum.SUCCESS.getCode());
		response.setResMsg(MsgEnum.SUCCESS.getMsg());
		response.setResDate(DateUtil.toCurrentDefaultDateString());
		
		return response;
	}
	
	
	/** 댓글 작성 (4021) */
	@Override
	@Transactional
	public Res4021 replyInsert(Req4021 req4021) {
		Res4021 response = new Res4021();
		int result = boardMapper.replyInsert(req4021);
		
		if(result > 0) {
			response.setResResult(MsgEnum.SUCCESS.getCode());
			response.setResMsg(MsgEnum.SUCCESS.getMsg());
		}else {
			response.setResResult(MsgEnum.FAIL.getCode());
			response.setResMsg(MsgEnum.FAIL.getMsg());
		}
		response.setResDate(DateUtil.toCurrentDefaultDateString());
		
		return response;
	}
}
