package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 通过用户Id获取用户信息
     *
     * @param userId
     * @return
     */
    User getUserById(int userId);

    /**
     * 增加用户信息
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    boolean modifyUser(User user);

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    boolean deleteUser(int userId);

}
