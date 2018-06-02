package com.vue.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vue.api.vo.TestVo;

@Mapper
public interface TestMapper {

	@Select(" SELECT 'GOOD JOB2 ~!' AS TEST_VALUE\r\n" + 
			"  FROM DUAL ")
	TestVo getTestValue();

	
	
}
