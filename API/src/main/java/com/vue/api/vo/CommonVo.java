package com.vue.api.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommonVo {
	
	/** 등록자 */
	private String regUser;

	/** 등록일자 */
	private LocalDateTime regDate;

	/** 수정자 */
	private String updUser;

	/** 수정일자 */
	private LocalDateTime updDate;

}
