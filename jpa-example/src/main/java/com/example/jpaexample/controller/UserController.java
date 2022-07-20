package com.example.jpaexample.controller;

import com.example.jpaexample.entity.User;
import com.example.jpaexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        // 自己在做 Save 的时候先去 Find 一下，其实是没有必要的，Spring JPA 底层都考虑到了。
        // TODO 这里其实是想告诉你，当我们用任何第三方方法的时候，最好先查一下其源码和逻辑或者 API，然后再写出优雅的代码。
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
    /**
     * 验证排序和分页查询方法，Pageable的默认实现类：PageRequest
     * @return
     */
    @GetMapping(path = "/page")
    @ResponseBody
    public Page<User> getAllUserByPage() {
        return userRepository.findAll(
                PageRequest.of(1, 20, Sort.by(new
                        Sort.Order(Sort.Direction.ASC,"name"))));
    }
    /**
     * 排序查询方法，使用Sort对象
     * @return
     */
    @GetMapping(path = "/sort")
    @ResponseBody
    public Iterable<User> getAllUsersWithSort() {
        return userRepository.findAll(Sort.by(new
                Sort.Order(Sort.Direction.ASC,"name")));
    }
}

