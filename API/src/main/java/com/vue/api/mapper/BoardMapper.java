package com.vue.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.vue.api.request.Req4020;
import com.vue.api.request.Req4021;
import com.vue.api.util.PageUtil;
import com.vue.api.vo.boardVo.BoardVo;
import com.vue.api.vo.boardVo.ReplyVo;

@Mapper
public interface BoardMapper {

	/** 게시판 목록보기 (4010) 
	 * @param pageInfo 
	 * @param request */
	@SelectProvider(type=ProviderBoardMapper.class, method="findByBoardList")
	List<BoardVo> findByBoardList(@Param("req") Req4020 request, @Param("page") PageUtil pageSetting);

	class ProviderBoardMapper{
		
		public String findByBoardList(@Param("req") Req4020 request, @Param("page") PageUtil pageSetting) {
			return new SQL() {
				{
					SELECT(" A.BOARD_NO "  
							+" ,A.TITLE	"  
							+" ,A.REG_DATE "  
							+" ,A.REG_USER "  
							+" ,COUNT(B.BOARD_NO) AS REPLY_CNT "  );
					FROM( " BOARD A LEFT OUTER JOIN REPLY B "
							+ "                       ON A.BOARD_NO = B.BOARD_NO ");
					WHERE(" 1=1 ");
					if("01".equals(request.getCategory())) {
						AND();
					  WHERE(" A.TITLE LIKE CONCAT('%', #{req.input}, '%') ");
					}else if("02".equals(request.getCategory())) {
						AND();
						WHERE(" A.TITLE LIKE CONCAT('%', #{req.input}, '%') ");
					}
					GROUP_BY("  A.BOARD_NO "
							+" ,A.TITLE "
							+" ,A.REG_DATE "
							+" ,A.REG_USER " );
					ORDER_BY("  A.REG_DATE DESC "
							+ " LIMIT #{page.limit}, #{page.increment} ");
				}
			}.toString();
		}
	}
	
	
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
