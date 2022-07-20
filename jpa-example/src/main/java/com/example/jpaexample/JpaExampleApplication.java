package com.example.jpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * @author 14688
 * jpa 项目测试
 * <p>
 *      QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND
 *      默认@query注解启用配置
 * </p>
 */
@SpringBootApplication
@EnableJpaRepositories(queryLookupStrategy=
        QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class JpaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaExampleApplication.class, args);
    }

}
