package com.vue.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue.api.service.TestService;
import com.vue.api.vo.TestVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags = "테스트컨트롤러", value = "테스트컨트롤러", description = "테스트컨트롤러 관련 API")
public class test {

	@Autowired
	private TestService testService;
	
	@CrossOrigin
	@ApiOperation(value = "스웨거 테스트")		//이 Api 매서드 설명
	@GetMapping(value="/test")
	public ResponseEntity<TestVo> testm(){
		
		TestVo vo = testService.getTest();
		
		return new ResponseEntity<TestVo>(vo, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/member-0001")
	public ResponseEntity<Res0001> testma(Req0001 req){
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