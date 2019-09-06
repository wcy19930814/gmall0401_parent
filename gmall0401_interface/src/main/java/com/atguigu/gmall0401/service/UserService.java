package com.atguigu.gmall0401.service;

import com.atguigu.gmall0401.entity.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> getUserInfoListAll();

    void addUser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    void updateUserByName(String name, UserInfo userInfo);

    void delUser(String id);

    UserInfo getUserInfo(String id);
}
