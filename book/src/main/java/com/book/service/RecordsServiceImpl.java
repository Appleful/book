package com.book.service;

import com.book.dao.BookMapper;
import com.book.dao.RecordsMapper;
import com.book.entity.Records;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class RecordsServiceImpl implements RecordsService{

    @Autowired
    private RecordsMapper recordsMapper;

    public void setRecordsMapper(RecordsMapper recordsMapper) {
        this.recordsMapper = recordsMapper;
    }

    public int addRecords(Records records) {
        return recordsMapper.addRecords(records);
    }

    public int deleteRecordsById(int id) {
        return recordsMapper.deleteRecordsById(id);
    }

    public int updateRecords(Records records) {
        return recordsMapper.updateRecords(records);
    }

    public Records queryRecordsById(int id) {
        return recordsMapper.queryRecordsById(id);
    }

    public List<Map<String, Object>> queryAllRecords(String userName,String bookName,int isreturn,int userid)
    {
        List<Map<String, Object>> maps = recordsMapper.queryAllRecords(userName,bookName,isreturn,userid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> map : maps) {
            Date s = (Date)map.get("start");
            map.replace("start",sdf.format(s));
            if(map.get("end")!=null && map.get("end")!=""){
                Date e = (Date)map.get("end");
                map.replace("end",sdf.format(e));
            }
        }
        return maps;
    }

    public List<Map<String, Object>> currList(String userName , String bookName,int userid) {
        List<Map<String, Object>> maps = recordsMapper.currList(userName,bookName,userid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> map : maps) {
            Date s = (Date)map.get("start");
            map.replace("start",sdf.format(s));
            if(map.get("end")!=null && map.get("end")!=""){
                Date e = (Date)map.get("end");
                map.replace("end",sdf.format(e));
            }
        }
        return maps;
    }

    public List<Map<String, Object>> confirm(String userName , String bookName,int userid) {
        List<Map<String, Object>> maps = recordsMapper.confirm(userName,bookName,userid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> map : maps) {
            Date s = (Date)map.get("start");
            map.replace("start",sdf.format(s));
            if(map.get("end")!=null && map.get("end")!=""){
                Date e = (Date)map.get("end");
                map.replace("end",sdf.format(e));
            }
        }
        return maps;
    }
}
