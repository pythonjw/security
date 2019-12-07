package com.pjw.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    //根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //将来连接数据库根据账号查询用户信息
        //暂时采用模拟方式
        UserDetails userDetails= User.withUsername("pakhm").password("123").authorities("p1").build();
        return userDetails;
    }
}
