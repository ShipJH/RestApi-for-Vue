package com.vue.api.response;


import com.vue.api.response.common.ResResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Res4020List extends ResResult{

	@ApiModelProperty(value="댓글번호", dataType="int")
	private int replyNo;

	@ApiModelProperty(value="게시글번호", dataType="int")
	private int boardNo;

	@ApiModelProperty(value="댓글내용", dataType="String")
	private String content;

	@ApiModelProperty(value="댓글 그룹번호", dataType="int")
	private int replyGroup;

	@ApiModelProperty(value="댓글 상태", dataType="String")
	private String useYn;

}
