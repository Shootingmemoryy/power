package com.bite.java_chartoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-02-12-23:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSession {
    private int sessionId;
    private List<Friend> friends;
    private String lastMessage;
}
