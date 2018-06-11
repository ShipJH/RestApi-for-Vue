package com.vue.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestVo {

	@ApiModelProperty(value = "테스트응답값", dataType = "string")
	private String testValue;
}
