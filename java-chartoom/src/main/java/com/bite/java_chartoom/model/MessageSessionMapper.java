package com.bite.java_chartoom.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-02-12-23:33
 */
@Mapper
public interface MessageSessionMapper {
    List<Integer> getSessionIdsByUserId(int userId);
    List<Friend> getFriendsBySessionId(@Param("sessionId") int sessionId, @Param("selfUserId") int selfUserId);
    int addMessageSession(MessageSession messageSession);
    void addMessageSessionUser(MessageSessionUserItem messageSessionUserItem);
}
