package com.ylw.service.test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylw.mapper.test01.UserMapperTest01;


import java.util.UUID;

@Service
public class UserServiceTest01 {
    @Autowired
    private UserMapperTest01 userMapperTest01;

    @Transactional
    public int insertUser(String name, Integer age) {
        int insertUserResult = userMapperTest01.insert(UUID.randomUUID().toString(), name, age);
        System.out.println("######insertUserResult:{}##########-> " + insertUserResult);
        //int i = 1 / age;
        // 怎么样验证事务开启成功!~
        return insertUserResult;
    }

}
