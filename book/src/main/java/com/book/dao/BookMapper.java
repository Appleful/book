package com.book.dao;

import com.book.entity.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository
public interface BookMapper {
    //增加
    int addBooks(Books book);

    //删除
    int deleteBooksById(@Param("id") int id);

    //修改信息
    int updateBooks(Books book);

    //查询
    Books queryBookById(@Param("id") int id);

    //查询全部
    List<Books> queryAllBook();

    //更新状态
    int updateStatus(int id);

    //查询部分信息
    List<Books> queryBook(@Param("name")String name,@Param("status")int status);

    //查询最近上架的10本书
    List<Books> newBook(@Param("name")String name,@Param("status")int status);

    //查询未借出的书
    List<Map<String ,Object>> selectName();

}
