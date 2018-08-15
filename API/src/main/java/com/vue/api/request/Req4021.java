package com.vue.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/** 댓글 작성 (4021) */
@Data
public class Req4021 {
	
	@ApiModelProperty(value="댓글번호", dataType="int")
	private int replyNo;

	@ApiModelProperty(value="게시글번호", dataType="int", required=true)
	private int boardNo;

	@ApiModelProperty(value="댓글내용", dataType="String", required=true)
	private String content;

	@ApiModelProperty(value="댓글 그룹번호", dataType="int")
	private int replyGroup;

}
