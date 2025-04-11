package com.bite.java_chartoom.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-02-21-15:10
 */
@Mapper
public interface MessageMapper {
    String getLastMessageBySessionId(int sessionId);

    List<Message> getMessagesBySessionId(int sessionId);

    void add(Message message);
}
