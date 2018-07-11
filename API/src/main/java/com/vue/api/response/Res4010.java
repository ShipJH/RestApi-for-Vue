package com.vue.api.response;

import java.util.ArrayList;
import java.util.List;

import com.vue.api.response.common.ResResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/** 게시판 목록보기 vo (4010) */
@Data
@EqualsAndHashCode(callSuper = true)
public class Res4010 extends ResResult {
	
	@ApiModelProperty(value = "총 게시글 수", dataType = "int", position=0)
	private int listCnt; 
	
	@ApiModelProperty(value = "요청 페이지 번호", dataType = "int", position=1)
	private int pageNo;
	
	@ApiModelProperty(value = "게시판 목록 리스트", dataType = "list", position=2)
	private List<Res4010List> boardList;
	
	public void addList(Res4010List res4010List) {
		if(boardList == null) {
			boardList = new ArrayList<>();
		}
		boardList.add(res4010List);
	}

}
