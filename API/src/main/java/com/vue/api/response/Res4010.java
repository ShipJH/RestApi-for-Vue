package com.vue.api.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Res4010 {
	
	private List<Res4010List> boardList;
	
	public void addList(Res4010List res4010List) {
		if(boardList == null) {
			boardList = new ArrayList<>();
		}
		boardList.add(res4010List);
	}

}
