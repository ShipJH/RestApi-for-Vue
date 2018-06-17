package com.vue.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue.api.response.Res4010;
import com.vue.api.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags = "게시판 API", value = "게시판 API", description = "게시판 API")
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private TestService testService;
	
	@CrossOrigin
	@ApiOperation(value = "게시판 목록보기")		//이 Api 매서드 설명
	@GetMapping(value="/4010")
	public ResponseEntity<Res4010> testm(){
		
		
		return new ResponseEntity<Res4010>(new Res4010(), HttpStatus.OK);
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