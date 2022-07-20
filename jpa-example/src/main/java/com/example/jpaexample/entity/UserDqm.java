package com.example.jpaexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: linK
 * @Date: 2022/7/20 17:17
 * @Description TODO Defining Query Method 的命名语法与参数  用于测试DQM的实体类
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDqm {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
