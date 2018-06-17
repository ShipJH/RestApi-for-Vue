package com.vue.api.response;

import lombok.Data;

@Data
public class Res4020 {

	/** 댓글 일련번호 */
	private int replyNo;

	/** 게시판 일련번호 */
	private int boardNo;

	/** 댓글 내용 */
	private String content;

	/** 댓글 그룹번호(댓글 일련번호[상위댑스])  */
	private int replyGroup;

	/** 댓글 상태  : Y-활성 , N-비활성(삭제) */
	private String useYn;

}
