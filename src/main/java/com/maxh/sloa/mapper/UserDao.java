package com.maxh.sloa.mapper;

import com.maxh.sloa.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 根据账号查询用户信息
     * @param account
     * @return
     */
    User findFirstByAccount(String account);

    List<User> findAll(User user);

    User findOne(Long id);

    int countByUserName(String account);
}
