package com.example.jpaexample.repository;

import com.example.jpaexample.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;


/**
 * @Author: linK
 * @Date: 2022/7/20 16:23
 * @Description TODO @SpringBootTest 注解正常
 * <p>
 *  Spring Data JPA 测试用例的写法   增加测试读取配置文件
 *  @see @RunWith(SpringRunner.class)
 *  @Import(UserRepository.class) 增加使用的类
 *  @DataJpaTest 注解会报错 Failed to replace DataSource with an embedded database for tests.
 *  If you want an embedded database please put a supported one on the classpath or tune the replace attribute of @AutoConfigureTestDatabase.
 *  加上 @AutoConfigureTestDatabase(replace =
 *         AutoConfigureTestDatabase.Replace.NONE)
 *  1. 测试的时候配置的数据库参数会被覆盖掉，这个卡了我一下，需要在测试类上加注解不覆盖配置。@AutoConfigureTestDatabase(replace =AutoConfigureTestDatabase.Replace.NONE)
 *  2. 使用 mysql 的时候实体类是要加上无参构造全参构造才行的。
 *  3. 前面实体类贴的代码没有加上 builder 注解，但是测试类就用上了 builder，这个不熟悉的朋友可能就会疑惑了。实体类加上 lombok的">@Builder注解就好
 * </p>
 */
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user =
                userRepository.save(User.builder().name("jackxx").email("123456@126.com")
                        .build());
        Assert.assertNotNull(user);
        List<User> users= userRepository.findAll();
        System.out.println(users);
        Assert.assertNotNull(users);
        /**[User(id=1, name=jack, email=123@126.com), User(id=2, name=jack, email=123@126.com),
         *  User(id=3, name=jack, email=123@126.com), User(id=4, name=jackxx, email=123456@126.com),
         *  User(id=5, name=jackxx, email=123456@126.com), User(id=6, name=jackxx, email=123456@126.com)]*/
        //Hibernate: select next_val as id_val from hibernate_sequence for update
        //Hibernate: update hibernate_sequence set next_val= ? where next_val=?
        //Hibernate: insert into users (email, name, id) values (?, ?, ?)
        //Hibernate: select user0_.id as id1_0_, user0_.email as email2_0_, user0_.name as name3_0_ from users user0_
        //[User(id=1, name=jack, email=123@126.com), User(id=2, name=jack, email=123@126.com), User(id=3, name=jack, email=123@126.com),
        // User(id=4, name=jackxx, email=123456@126.com), User(id=5, name=jackxx, email=123456@126.com), User(id=6, name=jackxx, email=123456@126.com), User(id=7, name=jackxx, email=123456@126.com)]
    }
}