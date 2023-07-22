package com.book.service;

import com.book.dao.RecordsMapper;
import com.book.entity.Records;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface RecordsService {

    public void setRecordsMapper(RecordsMapper recordsMapper) ;
    //增加
    public int addRecords(Records records);

    //删除
    public int deleteRecordsById(@Param("id") int id);

    //修改信息
    public int updateRecords(Records records);

    //查询
    public Records queryRecordsById(@Param("id") int id);

    //查询全部
    public List<Map<String, Object>> queryAllRecords(String userName,String bookName,int isreturn,int userid);

    public List<Map<String, Object>> currList(String userName , String bookName,int userid);

    public List<Map<String, Object>> confirm(String userName , String bookName,int userid);
}
