package com.vue.api.response;

import java.util.ArrayList;
import java.util.List;

import com.vue.api.response.common.ResResult;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** 댓글 목록 vo(4020) */
@Data
@EqualsAndHashCode(callSuper = true)
public class Res4020 extends ResResult {

	private List<Res4020List> replyList;
	
	public void addList(Res4020List res4020List) {
        if(replyList == null) {
        	replyList = new ArrayList<>();
        }
        replyList.add(res4020List);
    }
	
}
