package com.vue.api.response.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResResult {
	
	@ApiModelProperty(value = "응답값 : 0-성공, 1-실패", dataType = "String", position=1)
	private String resResult;
	
	@ApiModelProperty(value = "응답메세지", dataType = "String", position=1)
	private String resMsg;
	
	@ApiModelProperty(value = "응답시간", dataType = "String", position=1)
	private String resDate;
}
