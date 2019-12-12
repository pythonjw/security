package com.pjw.service;

import com.pjw.entity.MyUserDetails;
import com.pjw.mapper.MyUserDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    MyUserDetailsMapper myUserDetailsMapper;

    //根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<MyUserDetails> list= myUserDetailsMapper.selectUser(userName);
        if(list.size()==0){
            return null;
        }else{
            MyUserDetails myUserDetails=list.get(0);
            //将来连接数据库根据账号查询用户信息
            //暂时采用模拟方式
            List<String> permissionCode=myUserDetailsMapper.selectPermissionByUserName(userName);
            String[] permissionCodeArr=new String[permissionCode.size()];
            permissionCode.toArray(permissionCodeArr);
            UserDetails userDetails= User.withUsername(myUserDetails.getUserName()).password(myUserDetails.getPassWord()).authorities(permissionCodeArr).build();
            return userDetails;
        }
    }
}
