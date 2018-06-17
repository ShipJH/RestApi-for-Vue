package com.vue.api.response;

import java.util.List;

import lombok.Data;

@Data
public class Res4010 {
	
	/** 게시글 번호 */
	private int boardNo;

	/** 게시판 제목 */
	private String title;

	/** 게시판 상태 : Y-활성, N-비활성(삭제) */
	private String useYn;
}
