package com.vue.api.vo.comVo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommonVo {
	
	/** 등록자 */
	private int regUser;

	/** 등록일자 */
	private LocalDateTime regDate;

	/** 수정자 */
	private int updUser;

	/** 수정일자 */
	private LocalDateTime updDate;

}
