package com.bite.java_chartoom.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

        int insert(User user);

        User selectByName(String name);
}
