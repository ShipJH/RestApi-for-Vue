package com.vue.api.response;

import java.util.ArrayList;
import java.util.List;

import com.vue.api.response.common.ResCommon;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Res4010 extends ResCommon {
	
	@ApiModelProperty(value = "게시판 목록 리스트", dataType = "list", position=1)
	private List<Res4010List> boardList;
	
	public void addList(Res4010List res4010List) {
		if(boardList == null) {
			boardList = new ArrayList<>();
		}
		boardList.add(res4010List);
	}

}
