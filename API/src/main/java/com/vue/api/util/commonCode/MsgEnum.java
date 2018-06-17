package com.vue.api.util.commonCode;

import lombok.Getter;
import lombok.Setter;

public enum MsgEnum {

	SUCCESS("0","success."),
	FAIL("1","fail")
	;	
	
	/** 코드 정보 */
	@Getter @Setter
	private String code;
	
	/** 코드 값 */
	@Getter	@Setter
	private String msg;
    
    private MsgEnum(String code, String msg) {
    	this.code = code;
    	this.msg = msg;
    }
	
}
