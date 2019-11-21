package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 列出区域列表
     */
    List<User> queryUser();

    /**
     * 根据Id列出具体区域
     */
    User queryUserById(int userId);

    /**
     * 插入区域信息
     */
    int insertUser(User user);

    /**
     * 更新区域信息
     */
    int updateUser(User user);

    /**
     * 删除区域信息
     */
    int deleteUser(int userId);
}
