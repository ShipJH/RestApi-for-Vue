package com.vue.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vue.api.vo.boardVo.BoardVo;

@Mapper
public interface BoardMapper {

	@Select(" SELECT A.BOARD_NO \r\n" + 
			"	  	,A.TITLE	\r\n" + 
			"	  	,A.REG_DATE \r\n" + 
			"       ,A.REG_USER \r\n" + 
			"       ,COUNT(B.BOARD_NO) AS REPLY_CNT					\r\n" + 
			"  FROM BOARD A LEFT OUTER JOIN REPLY B 				\r\n" + 
			"							 ON A.BOARD_NO = B.BOARD_NO \r\n" + 
			" GROUP BY A.BOARD_NO  \r\n" + 
			"		  ,A.TITLE     \r\n" + 
			"         ,A.REG_DATE  \r\n" + 
			"         ,A.REG_USER ")
	List<BoardVo> findByBoardList();


	
	
}
