package com.vue.api.vo.boardVo;

import com.vue.api.vo.comVo.CommonVo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BoardVo extends CommonVo{

	/** 게시판 일련번호 */
	private int boardNo;

	/** 게시판 제목 */
	private String title;

	/** 게시판 내용 */
	private String content;

	/** 게시판 상태 : Y-활성, N-비활성(삭제) */
	private String useYn;
	
}
