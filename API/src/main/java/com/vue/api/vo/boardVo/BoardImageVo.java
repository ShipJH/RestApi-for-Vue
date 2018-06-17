package com.vue.api.vo.boardVo;

import lombok.Data;

@Data
public class BoardImageVo {

	/** 이미지 일련번호 */
	private int imgNo;

	/** 게시판 일련번호 */
	private int boardNo;

	/** 이미지 경로 */
	private String imgDir;

	/** 이미지 이름 */
	private String imgName;

	/** 이미지 크기 */
	private int imgSize;

}
