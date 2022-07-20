package com.example.jpaexample.repository;

import com.example.jpaexample.entity.EmailAddress;
import com.example.jpaexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: linK
 * @Date: 2022/7/20 15:25
 * @Description TODO  T, ID
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据名称进行查询用户列表
     *
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据用户的邮箱和名称查询
     *
     * @param email
     * @param name
     * @return
     */
    List<User> findByEmailAndName(String email, String name);

    @Nullable
    User findByEmailAddress(@Nullable EmailAddress emailAdress);
    //当我们添加@Nullable 注解之后，参数和返回结果这个时候就都会允许为 null 了；

    Optional<User> findOptionalByEmailAddress(EmailAddress emailAddress);
    //返回结果允许为 null,参数不允许为 null 的情况

}
