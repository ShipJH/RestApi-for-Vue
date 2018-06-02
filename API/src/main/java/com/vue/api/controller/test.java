package com.vue.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue.api.responseVo.TestVo;

@RestController
public class test {

	@GetMapping(value="/test")
	public ResponseEntity<TestVo> testm(){
		
		String msg = "ok~~";
		TestVo vo = new TestVo();
		vo.setMsg(msg);
		
		return new ResponseEntity<TestVo>(vo, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/testa")
	public ResponseEntity<String> testma(HttpServletRequest req){
		String a= req.getParameter("id");
		System.out.println(a);
		String msg = "ok~~";
		if("z".equals(a)) {
			msg = "zzzzzzzzzzzzzz!!!";
		}else {
			msg = "gggggggggggggggggggggggggggggggggg";
		}
		
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}