package com.vue.api.response.common;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResCommon {

	
	@ApiModelProperty(value = "등록자", dataType = "String", position=100)
	private String regUser;

	@ApiModelProperty(value = "등록일자", dataType = "Date", position=101)
	private String regDate;

	@ApiModelProperty(value = "수정자", dataType = "String", position=102)
	private String updUser;

	@ApiModelProperty(value = "수정일자", dataType = "Date", position=103)
	private String updDate;
	
}
