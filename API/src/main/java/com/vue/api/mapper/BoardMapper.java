package com.vue.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.vue.api.request.Req4021;
import com.vue.api.vo.boardVo.BoardVo;
import com.vue.api.vo.boardVo.ReplyVo;

@Mapper
public interface BoardMapper {

	/** 게시판 목록보기 (4010) */
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

	/** 게시글 상세보기 (4012) */
	@Select("SELECT * FROM BOARD WHERE BOARD_NO = #{boardNo}")
	BoardVo findByBoardDetail(int boardNo);
	
	/** 댓글 목록 (4020) */
	@Select("SELECT * "
			+ "FROM REPLY "
			+ "WHERE BOARD_NO=#{boardNo} "
			+ "ORDER BY IF(ISNULL(REPLY_GROUP),REPLY_NO, REPLY_GROUP),REPLY_NO")
	List<ReplyVo> findByreplyList(int boardNo);
	
	/** 댓글 작성 (4021) */
	@Insert("INSERT INTO REPLY "
			+ "(BOARD_NO, CONTENT, REPLY_GROUP, USE_YN, REG_USER) "
			+ "VALUES"
			+ "(#{boardNo},#{content},null,'Y','1')")
	@Options(useGeneratedKeys = true, keyProperty = "replyNo")
	int replyInsert(Req4021 req4021);
}
