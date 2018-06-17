package com.vue.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vue.api.vo.boardVo.BoardVo;

@Mapper
public interface BoardMapper {

	@Select(" SELECT BOARD_NO \n" 
			+"	    ,TITLE   \n"  
			+"      ,USE_YN  \n"
			+ " FROM BOARD ")
	List<BoardVo> findByBoardList();


	
	
}
