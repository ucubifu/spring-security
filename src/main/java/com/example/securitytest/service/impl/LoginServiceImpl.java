package com.example.securitytest.service.impl;

import com.example.securitytest.domain.LoginUser;
import com.example.securitytest.domain.ResponseResult;
import com.example.securitytest.domain.User;
import com.example.securitytest.service.LoginService;
import com.example.securitytest.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(User user) {
        //封装Authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        //通过AuthenticationManager的authenticate方法来进行用户认证
        Authentication authenticated = authenticationManager.authenticate(authenticationToken);
        LoginUser loginUser = (LoginUser) authenticated.getPrincipal();
        String jwt = JwtUtil.createToken(loginUser.getUser().getUsername());

        //把token返回给前端
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("token", jwt);
        return new ResponseResult(200, "登录成功", hashMap);
    }
}
