package com.example.securitytest.service.impl;

import com.example.securitytest.domain.LoginUser;
import com.example.securitytest.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!"test".equals(username)) {
            throw new RuntimeException("用户不存在");
        }

        // 根据用户名查询用户信息
        User user = new User("test", new BCryptPasswordEncoder().encode("123456"));

        // 将用户信息封装到UserDetails实现类中
        return new LoginUser(user);
    }
}
