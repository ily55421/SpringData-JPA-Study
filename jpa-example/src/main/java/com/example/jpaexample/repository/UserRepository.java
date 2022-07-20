package com.example.jpaexample.repository;

import com.example.jpaexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: linK
 * @Date: 2022/7/20 15:25
 * @Description TODO  T, ID
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 根据名称进行查询用户列表
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据用户的邮箱和名称查询
     * @param email
     * @param name
     * @return
     */
    List<User> findByEmailAndName(String email, String name);

}
