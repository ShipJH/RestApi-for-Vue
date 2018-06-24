package com.vue.api.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Res4010List {
	
	@ApiModelProperty(value = "게시글 번호 ", dataType = "int", position=1)
	private int boardNo;

	@ApiModelProperty(value = "게시글 제목 ", dataType = "string", position=2)
	private String title;

	@ApiModelProperty(value = " 게시판 상태 : Y-활성, N-비활성(삭제)  ", dataType = "string", position=3)
	private String useYn;
	
	@ApiModelProperty(value = "게시판 댓글 수", dataType = "int", position=3)
	private int replyCnt;
	
}
