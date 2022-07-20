package com.example.jpaexample.repository;

import com.example.jpaexample.entity.EmailAddress;
import com.example.jpaexample.entity.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @Author: linK
 * @Date: 2022/7/20 17:31
 * @Description TODO
 */
interface PersonRepository extends Repository<User, Long> {
    // and 的查询关系
    List<User> findByEmailAddressAndLastname(EmailAddress emailAddress,
                                             String lastname);

    // 包含 distinct 去重，or 的 sql 语法
    List<User> findDistinctPeopleByLastnameOrFirstname(String lastname,
                                                       String firstname);

    // 根据 lastname 字段查询忽略大小写
    List<User> findByLastnameIgnoreCase(String lastname);

    // 根据 lastname 和 firstname 查询 equal 并且忽略大小写
    List<User> findByLastnameAndFirstnameAllIgnoreCase(String lastname,
                                                       String firstname);

    // 对查询结果根据 lastname 排序，正序
    List<User> findByLastnameOrderByFirstnameAsc(String lastname);

    // 对查询结果根据 lastname 排序，倒序
    List<User> findByLastnameOrderByFirstnameDesc(String lastname);
}
