package com.vue.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.vue.api.vo.TestVo;

@Mapper
public interface TestMapper {

	@Select(" SELECT 'GOOD JOB ~!' AS TEST_VALUE "
			+ " FROM DUAL ")
	TestVo getTestValue();

	
	
}
