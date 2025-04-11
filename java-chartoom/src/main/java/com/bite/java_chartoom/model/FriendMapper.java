package com.bite.java_chartoom.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendMapper  {
        List<Friend> selectFriendList(int userId);
}
