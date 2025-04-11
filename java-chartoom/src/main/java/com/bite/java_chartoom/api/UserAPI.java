package com.bite.java_chartoom.api;

import com.bite.java_chartoom.model.User;
import com.bite.java_chartoom.model.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class UserAPI {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/login")
    @ResponseBody
    public Object login(String username, String password, HttpServletRequest request){
            User user =userMapper.selectByName(username);
            if(user==null||!user.getPassword().equals(password)){
                user.setPassword("");
                user.setUsername("");
                log.info("登录失败！用户名和密码错误"+user);
                return new User();
            }
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            user.setPassword("");
            return user;

       }
    @PostMapping("/register")
    @ResponseBody
    public Object register(String username, String password){
        User user=null;
        try{ user=new User();
            user.setUsername(username);
            user.setPassword(password);
            userMapper.insert(user);
            log.info("注册成功！"+user);
            user.setPassword("");

        }catch (DuplicateKeyException e){
            user=new User();
            log.info("注册失败！用户名已存在"+username);
        }

        return user;
    }
    @GetMapping("/userInfo")
    @ResponseBody
    public Object getUserInfo(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            log.info("[getUserInfo] session is null");
            return new User();
        }
        User user=(User)session.getAttribute("user");
        if(user==null){
        log.info("[getUserInfo] user is null");
        return new User();
        }
        user.setPassword("");
        return user;
    }
}
