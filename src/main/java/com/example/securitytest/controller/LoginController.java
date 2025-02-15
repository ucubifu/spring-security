package com.example.securitytest.controller;

import com.example.securitytest.domain.ResponseResult;
import com.example.securitytest.domain.User;
import com.example.securitytest.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        System.out.println("开始登录");
        return loginService.login(user);
    }
}