package com.bite.java_chartoom.component;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Shootingmemory
 * @create 2025-02-27-11:25
 */
@Component
public class OnlineUserManger {
    private ConcurrentHashMap<Integer, WebSocketSession> sessions = new ConcurrentHashMap<>();

    // 1) 用户上线, 给这个哈希表中插入键值对
    public void online(int userId, WebSocketSession session) {
        if (sessions.get(userId) != null) {
            // 此时说明用户已经在线了, 就登录失败, 不会记录这个映射关系.
            // 不记录这个映射关系, 后续就收不到任何消息 (毕竟, 咱们此处是通过映射关系来实现消息转发的)
            System.out.println("[" + userId + "] 已经被登录了, 登录失败!");
            return;
        }
        sessions.put(userId, session);
        System.out.println("[" + userId + "] 上线!");
    }

    // 2) 用户下线, 针对这个哈希表进行删除元素
    public void offline(int userId, WebSocketSession session) {
        WebSocketSession existSession = sessions.get(userId);
        if (existSession == session) {
            // 如果这俩 session 是同一个, 才真正进行下线操作. 否则就啥都不干
            sessions.remove((userId));
            System.out.println("[" + userId + "] 下线!");
        }
    }

    // 3) 根据 userId 获取到 WebSocketSession
    public WebSocketSession getSession(int userId) {
        return sessions.get(userId);
    }
}