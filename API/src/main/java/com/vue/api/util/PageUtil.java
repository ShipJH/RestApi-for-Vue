package com.vue.api.util;

import lombok.Data;

@Data
public class PageUtil {

	private int limit;
	private int increment;
	
	public PageUtil(int limit, int increment) {
		this.limit = (limit-1) * increment ;
		this.increment = increment;
	}
	
	
	
}
