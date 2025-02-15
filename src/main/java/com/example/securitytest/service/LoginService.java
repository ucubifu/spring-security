package com.example.securitytest.service;

import com.example.securitytest.domain.ResponseResult;
import com.example.securitytest.domain.User;

public interface LoginService {
    ResponseResult login(User user);
}
