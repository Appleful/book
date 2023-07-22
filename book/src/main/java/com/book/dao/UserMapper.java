package com.book.dao;

import com.book.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户
 */
@Repository
public interface UserMapper {

    //增加用户
    int addUser(User user);

    //删除用户
    int deleteUserById(@Param("id") int id);

    //修改用户信息
    int updateUser(User user);

    //查询用户
    User queryUserById(@Param("id") int id);

    //查询密码
    String queryUserByname(@Param("account") String account);

    //查询全部用户
    List<User> queryAllUser();

    //判断重名账户
    int selectAccount(@Param("account") String account);

    //判断账户类型
    int getRole(@Param("account") String account);

    List<Map<String,Object>> queryUserName(String account);

    int getId(String account);
}
