package com.vue.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue.api.request.Req4020;
import com.vue.api.response.Res4010;
import com.vue.api.response.Res4010List;
import com.vue.api.response.Res4012;
import com.vue.api.response.Res4020;
import com.vue.api.response.Res4020List;
import com.vue.api.service.impl.BoardServiceImpl;
import com.vue.api.service.impl.BoardServiceImpl1;
import com.vue.api.util.DateUtil;
import com.vue.api.util.commonCode.MsgEnum;
import com.vue.api.vo.boardVo.BoardVo;
import com.vue.api.vo.boardVo.ReplyVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags = "게시판 API", value = "게시판 API", description = "게시판 API")
@CrossOrigin
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardServiceImpl boardServiceImpl;
	@Autowired
	private BoardServiceImpl1 boardServiceImpl1;
	
	
	@ApiOperation(value = "게시판 목록보기")
	@GetMapping(value="/4010")
	public ResponseEntity<Res4010> testm(){
		
		Res4010 response = new Res4010();
		List<BoardVo> boardVo = boardServiceImpl.findByBoardList();
		
		for(BoardVo list : boardVo) {
			Res4010List res4010List = new Res4010List(); 
			res4010List.setBoardNo(list.getBoardNo());
			res4010List.setTitle(list.getTitle());
			res4010List.setUseYn(list.getUseYn());
			res4010List.setRegUser(list.getRegUser());
			res4010List.setRegDate(DateUtil.localDateTimeToStrDetail(list.getRegDate()));
			res4010List.setReplyCnt(list.getReplyCnt());
			response.addList(res4010List);
		}
		
		response.setResResult(MsgEnum.SUCCESS.getCode());
		response.setResMsg(MsgEnum.SUCCESS.getMsg());
		response.setResDate(DateUtil.toCurrentDefaultDateString());
		
		return new ResponseEntity<Res4010>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 목록")
	@GetMapping(value="/4020")
	public ResponseEntity<Res4020> reply(){
		Res4020 response = new Res4020();
//		Res4020List res4020List = new Res4020List();
		List<ReplyVo> relpyVo = boardServiceImpl1.findByreplyList();
		
		for(ReplyVo list : relpyVo) {
			Res4020List res4020List = new Res4020List();
			res4020List.setReplyNo(list.getReplyNo());
			res4020List.setBoardNo(list.getBoardNo());
			res4020List.setReplyGroup(list.getReplyGroup());
			res4020List.setContent(list.getContent());
			res4020List.setUseYn(list.getUseYn());
			response.addList(res4020List);
		}
		
		return new ResponseEntity<Res4020>(response, HttpStatus.OK);
	}

//	@ApiOperation(value = "댓글 목록")
//	@PostMapping(value="/4020")
//	public ResponseEntity<Res4020> reply(@RequestBody Request4020 req){
//		Res4020 response = new Res4020();
//
//
//		System.out.println("==================");
//		System.out.println("MyName : " + req.getMyName());
//		System.out.println("MyEmail : " + req.getMyEmail());
//		System.out.println("==================");
//		
//		
//		return new ResponseEntity<Res4020>(response, HttpStatus.OK);
//	}
	
	@ApiOperation(value = "댓글 작성")
	@PostMapping(value="/4021")
	public ResponseEntity<Res4020> replyInsert(@RequestBody Req4020 req4020){
		Res4020 response = new Res4020();
		System.out.println(req4020.getContent());
		boardServiceImpl1.replyInsert(req4020);
		System.out.println("==================");
		System.out.println(req4020.getReplyNo());
		System.out.println("==================");
		return new ResponseEntity<Res4020>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시글 상세 페이지")
	@GetMapping(value="/4012/{boardNo}")
	public ResponseEntity<Res4012> boardDetail(@PathVariable int boardNo){
		/*String boardNo=req.getParameter("boardNo");
		*/
		System.out.println("==================");
		System.out.println(boardNo);
		System.out.println("==================");
		
		Res4012 response = new Res4012();
		BoardVo boardVo = boardServiceImpl1.boardDetail(boardNo);
		
		response.setBoardNo(boardVo.getBoardNo());
		response.setTitle(boardVo.getTitle());
		response.setUseYn(boardVo.getUseYn());
		response.setRegUser(boardVo.getRegUser());
		response.setRegDate(DateUtil.localDateTimeToStrDetail(boardVo.getRegDate()));
		response.setReplyCnt(boardVo.getReplyCnt());


		return new ResponseEntity<Res4012>(response, HttpStatus.OK);
	}
}