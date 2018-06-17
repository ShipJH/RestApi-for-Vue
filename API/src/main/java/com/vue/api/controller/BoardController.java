package com.vue.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue.api.response.Res4010;
import com.vue.api.response.Res4020;
import com.vue.api.service.BoardService;
import com.vue.api.service.BoardService1;
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
	private BoardService boardService;
	@Autowired
	private BoardService1 boardService1;
	
	
	@ApiOperation(value = "게시판 목록보기")		//이 Api 매서드 설명
	@GetMapping(value="/4010")
	public ResponseEntity<List<Res4010>> testm(){
		
		List<Res4010> response = new ArrayList<>(); 
		List<BoardVo> boardVo = boardService.findByBoardList();
		
		for(BoardVo list : boardVo) {
			Res4010 res4010 = new Res4010(); 
			res4010.setBoardNo(list.getBoardNo());
			res4010.setTitle(list.getTitle());
			res4010.setUseYn(list.getUseYn());
			response.add(res4010);
		}
		
		return new ResponseEntity<List<Res4010>>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 목록")
	@GetMapping(value="/4020")
	public ResponseEntity<List<Res4020>> reply(){
		List<Res4020> response = new ArrayList<>(); 
		List<ReplyVo> relpyVo = boardService1.findByreplyList();
		
		for(ReplyVo list : relpyVo) {
			Res4020 res4020 = new Res4020();
			res4020.setReplyNo(list.getReplyNo());
			res4020.setBoardNo(list.getBoardNo());
			res4020.setReplyGroup(list.getReplyGroup());
			res4020.setContent(list.getContent());
			res4020.setUseYn(list.getUseYn());
			response.add(res4020);
		}
		
		return new ResponseEntity<List<Res4020>>(response, HttpStatus.OK);
	}
	
//	@PostMapping(value="/member-0001")
//	public ResponseEntity<Res0001> testma(Req0001 req){
//		String a= req.getParameter("id");
//		System.out.println(a);
//		String msg = "ok~~";
//		if("z".equals(a)) {
//			msg = "zzzzzzzzzzzzzz!!!";
//		}else {
//			msg = "gggggggggggggggggggggggggggggggggg";
//		}
//		
//		
//		return new ResponseEntity<String>(msg, HttpStatus.OK);
//	}
}