package com.book.dao;

import com.book.entity.Records;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository
public interface RecordsMapper {
    //增加
    int addRecords(Records records);

    //删除
    int deleteRecordsById(@Param("id") int id);

    //修改信息
    int updateRecords(Records records);

    //查询
    Records queryRecordsById(@Param("id") int id);

    //查询全部
    List<Map<String, Object>> queryAllRecords(@Param("userName")String userName,@Param("bookName")String bookName,@Param("isreturn")int isreturn,@Param("userid")int userid);

    //当前借阅
    List<Map<String, Object>> currList(@Param("userName")String userName,@Param("bookName")String bookName,@Param("userid") int userid);

    List<Map<String, Object>> confirm(@Param("userName")String userName,@Param("bookName")String bookName,@Param("userid") int userid);
}
