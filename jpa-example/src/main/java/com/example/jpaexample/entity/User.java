package com.example.jpaexample.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: linK
 * @Date: 2022/7/20 15:23
 * @Description TODO 用户实体类   user 表名在h2中会有冲突  改成users正常
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
