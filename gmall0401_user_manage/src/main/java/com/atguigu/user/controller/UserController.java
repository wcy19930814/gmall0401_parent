package com.atguigu.user.controller;

import com.atguigu.gmall0401.entity.UserInfo;
import com.atguigu.gmall0401.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(UserInfo userInfo){
        userService.addUser(userInfo);
        return "success";
    }

    @GetMapping("allUser")
    public List<UserInfo> getAllUser(){

        return  userService.getUserInfoListAll();
    }

    @GetMapping("userInfo/{id}")
    public UserInfo getUser(@PathVariable String id){

        return  userService.getUserInfo(id);
    }

    @PostMapping("delUser/{id}")
    public String deleteUser(@PathVariable String id){
        userService.delUser(id);
        return  "success";
    }

    @PostMapping("updateUser")
    public String updateUser(UserInfo userInfo){
        userService.updateUser(userInfo);

        userService.updateUserByName(userInfo.getName(),userInfo);
        return  "success";
    }

}
