package com.atguigu.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall0401.entity.UserInfo;
import com.atguigu.gmall0401.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Reference
    private UserService userService;

    @GetMapping("trade")
    public UserInfo trade(@RequestParam("id") String id){
        UserInfo userInfo = userService.getUserInfo(id);
        return userInfo;
    }
}
