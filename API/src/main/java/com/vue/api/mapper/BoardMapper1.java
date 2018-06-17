package com.vue.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vue.api.vo.boardVo.ReplyVo;

@Mapper
public interface BoardMapper1 {

	@Select("SELECT * FROM REPLY")
	List<ReplyVo> findByreplyList();
}
