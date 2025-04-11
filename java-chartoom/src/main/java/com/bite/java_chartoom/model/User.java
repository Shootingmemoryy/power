package com.bite.java_chartoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int UserId;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
