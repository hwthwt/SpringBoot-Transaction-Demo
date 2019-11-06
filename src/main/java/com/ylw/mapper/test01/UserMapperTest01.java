package com.ylw.mapper.test01;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ylw.entity.User;

public interface UserMapperTest01 {

	// 查询语句
	@Select("SELECT * FROM t_user WHERE name = #{name}")
	User findByName(@Param("name") String name);

	// 添加
	@Insert("INSERT INTO t_user(uuid,name, age) VALUES(#{uuid},#{name}, #{age})")
	int insert(@Param("uuid") String uuid,@Param("name") String name, @Param("age") Integer age);
}
