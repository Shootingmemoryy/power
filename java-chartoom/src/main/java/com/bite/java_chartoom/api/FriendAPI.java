package com.bite.java_chartoom.api;

import com.bite.java_chartoom.model.Friend;
import com.bite.java_chartoom.model.FriendMapper;
import com.bite.java_chartoom.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-02-09-22:55
 */
@Slf4j
@RestController
public class FriendAPI {
    @Resource
    private FriendMapper friendMapper;
    @GetMapping("/friendList")
    @ResponseBody
    public Object friendList(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null){
            return new ArrayList<Friend>();
        }

        User user = (User) session.getAttribute("user");
        if(user == null){
            log.info("[getFriendList] user 不存在");
            return new ArrayList<Friend>();
        }
        List<Friend> friendList=friendMapper.selectFriendList(user.getUserId());
        return friendList;
    }
}
