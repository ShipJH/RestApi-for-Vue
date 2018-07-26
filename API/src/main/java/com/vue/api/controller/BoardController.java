package com.vue.api.controller;

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
import com.vue.api.request.Req4021;
import com.vue.api.response.Res4010;
import com.vue.api.response.Res4012;
import com.vue.api.response.Res4020;
import com.vue.api.response.Res4021;
import com.vue.api.service.impl.BoardServiceImpl;
import com.vue.api.util.PageUtil;
import com.vue.api.util.commonCode.Code;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags = "게시판 API", value = "게시판 API", description = "게시판 API")
@CrossOrigin
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardServiceImpl boardServiceImpl;

	@ApiOperation(value = "게시판 목록보기")
	@GetMapping(value="/4010/{category}/{pageNo}/{input}")
	public ResponseEntity<Res4010> findByBoardList(@PathVariable String category,  @PathVariable int pageNo, @PathVariable String input){
		PageUtil pageSetting = new PageUtil(pageNo, Code.BOARD_INCREMENT);
		Req4020 request = new Req4020();
		request.setCategory(category);
		request.setPageNo(pageNo);
		request.setInput(input);
		Res4010 response = boardServiceImpl.findByBoardList(request,pageSetting);
		return new ResponseEntity<Res4010>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시글 상세 페이지")
	@GetMapping(value="/4012/{boardNo}")
	public ResponseEntity<Res4012> boardDetail(@PathVariable int boardNo){
		Res4012 response = boardServiceImpl.findByBoardDetail(boardNo);
		return new ResponseEntity<Res4012>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 목록")
	@GetMapping(value="/4020/{boardNo}")
	public ResponseEntity<Res4020> reply(@PathVariable int boardNo){
		Res4020 response = boardServiceImpl.findByReplyList(boardNo);
		return new ResponseEntity<Res4020>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 작성")
	@PostMapping(value="/4021")
	public ResponseEntity<Res4021> replyInsert(@RequestBody Req4021 req4021){
		Res4021 response = boardServiceImpl.replyInsert(req4021);
		return new ResponseEntity<Res4021>(response, HttpStatus.OK);
	}
	
	
}