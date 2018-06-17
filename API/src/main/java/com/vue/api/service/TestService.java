package com.vue.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.api.mapper.TestMapper;
import com.vue.api.service.impl.TestServiceImpl;

@Service
public class TestService implements TestServiceImpl{

	@Autowired
	private TestMapper testMapper;
	
//	@Override
//	public TestVo getTest() {
//		 
//		return testMapper.getTestValue();
//	}

	
}
