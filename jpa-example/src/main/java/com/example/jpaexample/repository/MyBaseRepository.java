package com.example.jpaexample.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * @Author: linK
 * @Date: 2022/7/20 17:23
 * @Description TODO 自定义接口暴露的仓库
 * <P>
 *     MyRepository Extends Repository 接口可以实现 Defining Query Methods 的功能；
 * 继承其他 Repository 的子接口，或者自定义子接口，可以选择性地暴露
 * SimpleJpaRepository 里面已经实现的基础公用方法。
 * </P>
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends
        Repository<T, ID> {
    T findOne(ID id);
    T save(T entity);
}

