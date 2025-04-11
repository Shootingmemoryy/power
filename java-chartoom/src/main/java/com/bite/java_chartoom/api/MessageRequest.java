package com.bite.java_chartoom.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Shootingmemory
 * @create 2025-02-27-17:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private String type = "message";
    private int sessionId;
    private String content;
}
