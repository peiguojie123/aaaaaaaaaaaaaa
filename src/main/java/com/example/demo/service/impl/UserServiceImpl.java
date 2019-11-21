package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        // 返回所有的用户信息
        return userDao.queryUser();
    }

    @Override
    public User getUserById(int UserId) {

        return userDao.queryUserById(UserId);
    }

    @Transactional  //加上事务控制  当抛出RuntimeException异常  事务就会回滚
    @Override
    public boolean addUser(User user) {
        // 空值判断，主要是判断UserName不为空
        if (user != null && !StringUtils.isEmpty(user.getUsername())) {
//            // 设置默认值
//            user.setCreateTime(new Date());  //设置当前时间
//            user.setLastEditTime(new Date());
            try {
                int effectedNum = userDao.insertUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加用户信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyUser(User user) {
        // 空值判断，主要是UserId不为空
        if (user != null && user.getId() != null &&  user.getId() > 0) {
            // 设置默认值
            user.setDelflag("U");
            try {
                // 更新用户信息
                int effectedNum = userDao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteUser(int userId) {
        if (userId > 0) {
            try {
                // 删除用户信息
                int effectedNum = userDao.deleteUser(userId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除用户信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户Id不能为空！");
        }
    }
}
