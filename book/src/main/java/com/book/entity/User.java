package com.book.entity;

import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    private int id;
    private String account;
    private String password;
    private int role;

    public User(int id, String account, String password, int role) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public User(){}
}
