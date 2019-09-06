package com.atguigu.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall0401.entity.UserInfo;
import com.atguigu.gmall0401.service.UserService;
import com.atguigu.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserInfoListAll() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }

    @Override
    public void addUser(UserInfo userInfo) {

        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {

        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",name);

        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void delUser(String id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserInfo getUserInfo(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
