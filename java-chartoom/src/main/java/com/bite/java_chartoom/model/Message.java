package com.bite.java_chartoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Shootingmemory
 * @create 2025-02-23-16:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int messageId;
    private int fromId; // 表示发送者用户 id
    private String fromName; // 表示发送者的用户名
    private int sessionId;
    private String content;
}
