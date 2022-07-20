package com.example.jpaexample.repository;

import com.example.jpaexample.entity.UserDqm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: linK
 * @Date: 2022/7/20 17:18
 * @Description TODO
 */
@Repository
public interface UserDqmRepository extends MyBaseRepository<UserDqm, Long> {
    /**
     * 查询邮件地址
     * @param emailAddress
     * @return
     */
    UserDqm findByEmailAddress(String emailAddress);

}
