package com.ylw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ylw.service.test01.UserServiceTest01;
import com.ylw.service.test02.UserServiceTest02;

@RestController
public class MybatisMultilDataSourceController {

	@Autowired
	private UserServiceTest01 userServiceTest01;
	@Autowired
	private UserServiceTest02 userServiceTest02;

	@RequestMapping(value = "/insertUserTest1" ,method = RequestMethod.GET)
	public Integer insertUserTest1(String name, Integer age) {
		return userServiceTest01.insertUser(name, age);
	}

	@RequestMapping(value = "/insertUserTest2",method = RequestMethod.GET)
	public Integer insertUserTest2(String name, Integer age) {
		return userServiceTest02.insertUser(name, age);
	}

	@RequestMapping(value ="/insertUserTest01AndTest02",method = RequestMethod.GET)
	public int insertUserTest01AndTest02(String name, Integer age) {
		return userServiceTest02.insertUserTest01AndTest02(name, age);
	}
}
