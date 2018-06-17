package com.vue.api.vo.boardVo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardLikeVo {

	/** 좋아요 일련번호 */
	private int boardLikeNo;

	/** 게시판 일련번호 */
	private int boardNo;

	/** 유저 일련번호 */
	private int userNo;

	/** 등록 일자 */
	private LocalDateTime regDate;

}
