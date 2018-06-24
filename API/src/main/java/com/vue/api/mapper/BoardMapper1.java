package com.vue.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.vue.api.request.Req4020;
import com.vue.api.vo.boardVo.BoardVo;
import com.vue.api.vo.boardVo.ReplyVo;

@Mapper
public interface BoardMapper1 {

	@Select("SELECT * FROM REPLY ORDER BY IF(ISNULL(REPLY_GROUP),REPLY_NO, REPLY_GROUP),REPLY_NO")
	List<ReplyVo> findByreplyList();
	
	@Insert("INSERT INTO REPLY "
			+ "(BOARD_NO, CONTENT, REPLY_GROUP, USE_YN, REG_USER) "
			+ "VALUES"
			+ "('1',#{content},null,'Y','1')")
	@Options(useGeneratedKeys = true, keyProperty = "replyNo")
	int replyInsert(Req4020 req4020);
	
	@Select("SELECT * FROM BOARD WHERE BOARD_NO = #{boardNo}")
	BoardVo boardDetail(int boardNo);
}
