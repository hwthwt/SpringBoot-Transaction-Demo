package com.ylw.service.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylw.mapper.test01.UserMapperTest01;
import com.ylw.mapper.test02.UserMapperTest02;


import java.util.UUID;

@Service
public class UserServiceTest02 {
    @Autowired
    private UserMapperTest02 userMapperTest02;
    @Autowired
    private UserMapperTest01 userMapperTest01;

    @Transactional
    public int insertUser(String name, Integer age) {
        int insertUserResult = userMapperTest02.insert(UUID.randomUUID().toString(), name, age);
        System.out.println("######insertUserResult:{}########## -> " + insertUserResult);
        // 怎么样验证事务开启成功!~
        //int i = 1 / age;
        return insertUserResult;
    }

    @Transactional()
    public int insertUserTest01AndTest02(String name, Integer age) {
        // 传统分布式事务解决方案 jta+atomikos 注册同一个全局事务中
        // 第一个数据源
        int insertUserResult01 = userMapperTest01.insert(UUID.randomUUID().toString(), name, age);
        // 第二个数据源
        int insertUserResult02 = userMapperTest02.insert(UUID.randomUUID().toString(), name, age);
        //int i = 1 / 0;
        int result = insertUserResult01 + insertUserResult02;
        // test01入库 test02回滚
        return result;
    }

}
