package com.vue.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue.api.responseVo.ReqTestVo;
import com.vue.api.service.TestService;
import com.vue.api.vo.TestVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
public class test {

	@Autowired
	private TestService testService;
	
	@CrossOrigin
	@ApiOperation(value = "스웨거 테스트")		//이 Api 매서드 설명
/*    @ApiImplicitParams({					//파라미터 이름과 설명 적용
            @ApiImplicitParam(),			//@PathVariable 파리미터는 반드시 parameterType="path"로 설정하고 
    })									//@RequestParam 파라미터는 parameterType="string"으로 설정해야 한다.
*/	@GetMapping(value="/test")
	public ResponseEntity<TestVo> testm(){
		
		TestVo vo = testService.getTest();
		
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