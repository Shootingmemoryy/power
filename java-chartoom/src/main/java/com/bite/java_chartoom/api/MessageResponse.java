package com.bite.java_chartoom.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Shootingmemory
 * @create 2025-02-27-17:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private String type = "message";
    private int fromId;
    private String fromName;
    private int sessionId;
    private String content;
}
