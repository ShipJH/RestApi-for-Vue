package com.vue.api.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Res4020 {

	private List<Res4020List> replyList;
	
	public void addList(Res4020List res4020List) {
        if(replyList == null) {
        	replyList = new ArrayList<>();
        }
        replyList.add(res4020List);
    }
	
}
