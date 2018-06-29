package com.vue.api.response;

import com.vue.api.response.common.ResResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/** 게시글 상세 페이지 vo (4012) */
@EqualsAndHashCode(callSuper = true)
@Data
public class Res4012 extends ResResult{
	
	@ApiModelProperty(value = "게시글 번호 ", dataType = "int", position=1)
	private int boardNo;

	@ApiModelProperty(value = "게시글 제목 ", dataType = "string", position=2)
	private String title;
	
	@ApiModelProperty(value = "게시글 내용 ", dataType = "string", position=3)
	private String content;
	
	@ApiModelProperty(value = " 게시판 상태 : Y-활성, N-비활성(삭제)  ", dataType = "string", position=4)
	private String useYn;
	
	@ApiModelProperty(value = "게시판 댓글 수", dataType = "int", position=5)
	private int replyCnt;
	
	@ApiModelProperty(value = "작성자", dataType = "String", position=6)
	private String regUser;
	
	@ApiModelProperty(value = "작성일자", dataType = "String", position=7)
	private String regDate;
}
