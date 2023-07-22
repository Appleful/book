package com.book.service;

import com.book.dao.UserMapper;
import com.book.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface UserService{

    public void setUserMapper(UserMapper userMapper) ;

    //增加用户
    public int addUser(User user);

    //删除用户
    public int deleteUserById(int id);

    //修改用户信息
    public int updateUser(User user);

    //查询用户
    public User queryUserById(int id);

    //查询全部用户
    public List<User> queryAllUser();

    //查询密码
    public String queryByname(String account);

    //判断重名账户
    public int selectAccount(String account);

    //判断账户类型
    public int getRole(String account);

    List<Map<String,Object>> queryUserName(String account);

    public int getId(String account);
}
