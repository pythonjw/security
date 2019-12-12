package com.pjw.mapper;

import com.pjw.entity.MyUserDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyUserDetailsMapper {
    List<MyUserDetails> selectUser(@Param("userName") String userName);
    List<String> selectPermissionByUserName(@Param("userName") String userName);
}
