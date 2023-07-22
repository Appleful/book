package com.book.service;

import com.book.dao.UserMapper;
import com.book.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 业务逻辑层实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //增加用户
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    //删除用户
    public int deleteUserById(int id){
        return userMapper.deleteUserById(id);
    }

    //修改用户信息
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    //查询用户
    public User queryUserById(int id){
        return userMapper.queryUserById(id);
    }

    //查询全部用户
    public List<User> queryAllUser(){
        return userMapper.queryAllUser();
    }

    //查询密码
    public String queryByname(String account){
        return userMapper.queryUserByname(account);
    }

    public int selectAccount(String account) {
        return userMapper.selectAccount(account);
    }

    public int getRole(String account) {
        return userMapper.getRole(account);
    }

    public List<Map<String,Object>> queryUserName(String account){
        return userMapper.queryUserName(account);
    }

    public int getId(String account) {
        return userMapper.getId(account);
    }
}
