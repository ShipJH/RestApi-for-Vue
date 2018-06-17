package com.vue.api.response.common;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResCommon {
	private String resResult;
	private String resMsg;
	private LocalDateTime resDate;
}
