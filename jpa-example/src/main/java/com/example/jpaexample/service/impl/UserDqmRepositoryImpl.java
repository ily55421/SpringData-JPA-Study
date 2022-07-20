package com.example.jpaexample.service.impl;

import com.example.jpaexample.entity.UserDqm;
import com.example.jpaexample.repository.UserDqmRepository;
import com.example.jpaexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: linK
 * @Date: 2022/7/20 17:20
 * @Description TODO   Defining Query Method 的命名语法与参数 测试
 */
@Service
public class UserDqmRepositoryImpl  {
    @Autowired
    UserDqmRepository userDqmRepository;
    public void testJpa() {
        // 非暴露方法
//        userDqmRepository.deleteAll();
//        userDqmRepository.findAll();
        // 可以直接调用 findByEmailAddress 方法
        userDqmRepository.findByEmailAddress("zjk@126.com");
    }

    /**
     * 测试自定义暴露接口方法
     */
    public void testJpaNoExpose() {
        userDqmRepository.save(null);
        userDqmRepository.findOne(2L);
        // 可以直接调用 findByEmailAddress 方法
        userDqmRepository.findByEmailAddress("zjk@126.com");
    }
}
