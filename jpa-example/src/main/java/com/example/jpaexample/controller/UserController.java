package com.example.jpaexample.controller;

import com.example.jpaexample.entity.User;
import com.example.jpaexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: linK
 * @Date: 2022/7/20 15:27
 * @Description TODO
 */
@RestController
@RequestMapping(path = "/api/v1")
public class UserController {


    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping(path = "user",consumes =
            {MediaType.APPLICATION_JSON_VALUE})
    public User addNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    /**
     * 根据分页信息查询用户
     * @param request  可分页的对象
     * @return
     */
    @GetMapping(path = "users")
    @ResponseBody
    public Page<User> getAllUsers(Pageable request) {
        return userRepository.findAll(request);
    }
}

