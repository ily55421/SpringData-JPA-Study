package com.example.jpaexample.service.impl;

import com.example.jpaexample.entity.User;
import com.example.jpaexample.repository.UserRepository;
import com.example.jpaexample.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: linK
 * @Date: 2022/7/20 17:46
 * @Description TODO
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long,
        UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

}
