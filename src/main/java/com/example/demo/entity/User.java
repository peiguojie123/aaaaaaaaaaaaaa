package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 用户信息表
 */
public class User {
    private int id;//编号
    private String username;//用户名
    private String loginid;//登录账号
    private String password;//密码
    private String phonenum;//电话号码
    private String picture;//头像
    private String status;//状态#ZTDM(1=启用 0=停用)
    private String delflag;//操作标识
}
